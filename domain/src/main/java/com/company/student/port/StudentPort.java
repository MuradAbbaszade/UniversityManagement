package com.company.student.port;

import com.company.student.model.Student;
import com.company.student.usecase.DeleteStudent;
import com.company.student.usecase.RetrieveStudent;
import com.company.student.usecase.SaveStudent;

import java.util.List;

public interface StudentPort {
    Student retrieve(RetrieveStudent retrieveStudent) throws Exception;
    List<Student> retrieveByEmail(RetrieveStudent retrieveStudent) throws Exception;
    List<Student> retrieveByGroup(RetrieveStudent retrieveStudent) throws Exception;
    Student delete(DeleteStudent deleteStudent) throws Exception;
    Student save(SaveStudent saveStudent);
}
