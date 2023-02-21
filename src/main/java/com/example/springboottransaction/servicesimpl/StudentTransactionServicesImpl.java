package com.example.springboottransaction.servicesimpl;

import com.example.springboottransaction.entity.CollegeInfo;
import com.example.springboottransaction.entity.Students;
import com.example.springboottransaction.entity.StudentsInfo;
import com.example.springboottransaction.repository.CollegeTransactionPropagationRepository;
import com.example.springboottransaction.repository.StudentTransactionPropagationRepository;
import com.example.springboottransaction.services.CollegeTransactionServices;
import com.example.springboottransaction.services.StudentTransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class StudentTransactionServicesImpl implements StudentTransactionServices {
    @Autowired
   CollegeTransactionServices collegeTransactionServices;

    @Autowired
   StudentTransactionPropagationRepository studentTransactionPropagationRepository;
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Students saveStudent(Students student) {

        StudentsInfo studentsInfo=new StudentsInfo();
        studentsInfo.setId(student.getStudentsInfo().getId());
        studentsInfo.setName(student.getStudentsInfo().getName());
        studentsInfo.setRoll(student.getStudentsInfo().getRoll());

        CollegeInfo collegeInfo= collegeTransactionServices.saveCollege(student);


        Students students=new Students();

        students.setStudentsInfo(studentsInfo);
        students.setCollegeInfo(collegeInfo);
        TransactionStatus status1 = TransactionAspectSupport.currentTransactionStatus();
        System.out.println("Student Status1 "+status1);
        studentTransactionPropagationRepository.save(studentsInfo);
        System.out.println("Students Saved");
        TransactionStatus status2 = TransactionAspectSupport.currentTransactionStatus();
        System.out.println("Student Status2 "+status2);
        return students;
    }
}
