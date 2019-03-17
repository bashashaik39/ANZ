package com.reciepe.demo2.Reciepedemo2.controller;

import java.lang.invoke.MethodType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciepe.demo2.Reciepedemo2.Entity.ReciepeEntity;
import com.reciepe.demo2.Reciepedemo2.Service.ReciepeService;
@RestController
public class ReciepeController {

	@Autowired
	private ReciepeService reciepeService;

	@PostMapping
	@RequestMapping(value="/save")
	public ResponseEntity<ReciepeEntity> savereciepe(@RequestBody ReciepeEntity reciepe) {
		ResponseEntity<ReciepeEntity> re = new ResponseEntity<>(HttpStatus.OK);
		reciepeService.saveReciepe(reciepe);
		return re;

	}
	
	@GetMapping
	@RequestMapping(value="/get")
	public ResponseEntity<List<ReciepeEntity>> getreciepe(){
	List<ReciepeEntity> list = reciepeService.getreciepe();
	ResponseEntity<List<ReciepeEntity>> re = new ResponseEntity<List<ReciepeEntity>>(list,HttpStatus.OK);
		return re;
		
	}
	

	@GetMapping
	@RequestMapping(value="/getbyid/{id}")
	public ResponseEntity<Optional<ReciepeEntity>> searchById(@PathVariable Integer id){
		Optional<ReciepeEntity> list =reciepeService.searchById(id);
		ResponseEntity<Optional<ReciepeEntity>> re = new ResponseEntity<>(list,HttpStatus.OK);
			return re;
		
	}
	
	
	
	
	

}
