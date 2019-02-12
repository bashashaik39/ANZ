package com.reciepe.ReciepeEx;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciepeDao extends JpaRepository<ReciepePojo, Integer> {

}
