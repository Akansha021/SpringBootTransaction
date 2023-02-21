package com.example.springboottransaction.services;

import com.example.springboottransaction.entity.CollegeInfo;
import com.example.springboottransaction.entity.Students;

public interface CollegeTransactionServices {
    CollegeInfo saveCollege(Students collegeInfo);
}
