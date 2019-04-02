package com.reciepe.demo2.Reciepedemo2;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.mockito.Mockito.times;
import static org.hamcrest.Matchers.is;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.reciepe.demo2.Reciepedemo2.Dao.ReciepeDao;
import com.reciepe.demo2.Reciepedemo2.Service.ReciepeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Reciepedemo2ApplicationTest {

	private MockMvc mockMvc;

	@Mock
	private ReciepeService service;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void verifyAllToDoSave() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/save").accept(MediaType.APPLICATION_JSON));

	}
	 

	@Test
	public void verifyAllToDoList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/get"))
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[1].id", is(2))).andExpect(jsonPath("$[2].id", is(3)))
				.andExpect(jsonPath("$[0].title", is("Creamy Scrambled Eggs Recipe Recipe")))
				.andExpect(jsonPath("$[1].title", is("Creamy Scrambled Eggs Recipe Recipe")))
				.andExpect(jsonPath("$[2].title", is("Creamy Scrambled Eggs Recipe Recipe")))
				.andExpect(jsonPath("$[0].thumbnail", is("http://img.recipepuppy.com/ 373064.jpg")))
				.andExpect(jsonPath("$[1].thumbnail", is("http://img.recipepuppy.com/ 373064.jpg")))
				.andExpect(jsonPath("$[2].thumbnail", is("http://img.recipepuppy.com/ 373064.jpg")))
				.andExpect(jsonPath("$[0].href", is("http://www.grouprecipes.com/43522/creamyscrambled-eggs-recipe.html")))
				.andExpect(jsonPath("$[1].href", is("http://www.grouprecipes.com/43522/creamyscrambled-eggs-recipe.html")))
				.andExpect(jsonPath("$[2].href", is("http://www.grouprecipes.com/43522/creamyscrambled-eggs-recipe.html")));
		verify(service, times(0)).getreciepe();
		verifyNoMoreInteractions(service);
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
				.andExpect(
						jsonPath("$.href").value("http://www.grouprecipes.com/43522/creamyscrambled-eggs-recipe.html"))
				.andDo(print());
	}
	
}
