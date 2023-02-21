package com.example.springboottransaction.repository;

import com.example.springboottransaction.entity.StudentsInfo;
import org.springframework.data.repository.CrudRepository;

public interface StudentTransactionPropagationRepository extends CrudRepository<StudentsInfo,Integer> {

}
