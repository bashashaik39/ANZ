package com.reciepe.demo2.Reciepedemo2;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Reciepedemo2ApplicationTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
 
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
            MockitoAnnotations.initMocks(this);
	}
	@Test
	public void verifyAllToDoList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/get").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(2))).andDo(print());
	}
	 
	@Test
	public void verifyToDoById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getbyid/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.title").exists())
		.andExpect(jsonPath("$.href").exists())
		.andExpect(jsonPath("$.ingredients").exists())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.title").value("Creamy Scrambled Eggs Recipe Recipe"))
		.andExpect(jsonPath("$.ingredients").isArray())
		.andExpect(jsonPath("$.href").value("http://www.grouprecipes.com/43522/creamyscrambled-eggs-recipe.html"))
		.andDo(print());
	}
	
	 
	}
