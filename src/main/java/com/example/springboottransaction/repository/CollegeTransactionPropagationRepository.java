package com.example.springboottransaction.repository;

import com.example.springboottransaction.entity.CollegeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeTransactionPropagationRepository extends CrudRepository<CollegeInfo,Integer> {

}
