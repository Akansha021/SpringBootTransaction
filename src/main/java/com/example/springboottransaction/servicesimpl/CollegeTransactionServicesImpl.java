package com.example.springboottransaction.servicesimpl;

import com.example.springboottransaction.entity.CollegeInfo;
import com.example.springboottransaction.entity.Students;
import com.example.springboottransaction.repository.CollegeTransactionPropagationRepository;
import com.example.springboottransaction.services.CollegeTransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


@Service
public class CollegeTransactionServicesImpl implements CollegeTransactionServices {

    @Autowired
    CollegeTransactionPropagationRepository collegeTransactionPropagationRepository;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public CollegeInfo saveCollege(Students collegeInfo) {
        CollegeInfo col=new CollegeInfo();
        col.setId(collegeInfo.getCollegeInfo().getId());
        col.setName(collegeInfo.getCollegeInfo().getName());

        TransactionStatus status1 = TransactionAspectSupport.currentTransactionStatus();
        System.out.println("College Status1 "+status1);
        collegeTransactionPropagationRepository.save(col);

        TransactionStatus status2 = TransactionAspectSupport.currentTransactionStatus();
        System.out.println("College Status2 "+status2);
        System.out.println("College Saved");
        return col;
    }
}
