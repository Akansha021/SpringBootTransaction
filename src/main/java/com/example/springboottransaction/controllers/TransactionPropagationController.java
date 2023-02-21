package com.example.springboottransaction.controllers;

import com.example.springboottransaction.entity.Students;
import com.example.springboottransaction.services.CollegeTransactionServices;
import com.example.springboottransaction.services.StudentTransactionServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity")
public class TransactionPropagationController {

    @Autowired
    CollegeTransactionServices collegeTransactionServices;
    @Autowired
    StudentTransactionServices studentTransactionServices;
    @GetMapping("/save")
    public Students saveStudent(@RequestBody Students obj){

        return studentTransactionServices.saveStudent(obj);
    }

}
