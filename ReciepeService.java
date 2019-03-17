package com.reciepe.demo2.Reciepedemo2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reciepe.demo2.Reciepedemo2.Dao.ReciepeDao;
import com.reciepe.demo2.Reciepedemo2.Entity.ReciepeEntity;
@Service
public class ReciepeService {
	
@Autowired
private ReciepeDao reciepeDao;
public void saveReciepe(ReciepeEntity re){
reciepeDao.save(re);
}


public List<ReciepeEntity> getreciepe() {
	List<ReciepeEntity> resp =reciepeDao.findAll();
	return resp;
}


public Optional<ReciepeEntity> searchById(Integer id) {
	Optional<ReciepeEntity> entity=reciepeDao.findById(id);
	return entity;
}

  
}
