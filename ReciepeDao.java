package com.reciepe.demo2.Reciepedemo2.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.reciepe.demo2.Reciepedemo2.Entity.ReciepeEntity;
@Repository
public interface ReciepeDao extends MongoRepository<ReciepeEntity, Integer>{
	

}
