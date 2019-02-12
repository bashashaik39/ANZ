package com.reciepe.ReciepeEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReciepeService {
	@Autowired
	private ReciepeDao rd;

	public void savedata(ReciepePojo reciepePojo) {
			List<Ingredients>list=reciepePojo.getIngredients();
			for (Ingredients ingredients : list) {
					ingredients.setPojo(reciepePojo);
			}
		rd.save(reciepePojo);
	}

	public List< ReciepePojo> getdata() {
		List<ReciepePojo> d= rd.findAll();
		return d;
		
		
	}

	public Optional<ReciepePojo> Searchmethod(Integer id) {
		Optional<ReciepePojo> e=rd.findById(id);
		return e;
	}

}
