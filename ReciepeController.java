package com.reciepe.ReciepeEx;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReciepeController {
	
	@Autowired
	private ReciepeService rs;

	@PostMapping
	@RequestMapping(value = "/save")
	public ResponseEntity<ReciepePojo> savedata(@RequestBody ReciepePojo reciepePojo) {
		ResponseEntity<ReciepePojo> re = new ResponseEntity<>(HttpStatus.OK);
		rs.savedata(reciepePojo);
		return re;

	}
	 
	@RequestMapping(value = "/get",method=RequestMethod.GET)
	public ResponseEntity<List<ReciepePojo>> getatamethod() {
		List<ReciepePojo> t=rs.getdata();
		ResponseEntity<List<ReciepePojo>> re = new ResponseEntity<List<ReciepePojo>>(t,HttpStatus.OK);
		return re;

	}
	
	@RequestMapping(value = "/search/{id}",method=RequestMethod.GET)
	public ResponseEntity<Optional<ReciepePojo>> searchmethod(@PathVariable Integer id) {
		Optional<ReciepePojo> t=rs.Searchmethod(id);
		ResponseEntity<Optional<ReciepePojo>> re = new ResponseEntity<Optional<ReciepePojo>>(t,HttpStatus.OK);
		return re;

	}
}
