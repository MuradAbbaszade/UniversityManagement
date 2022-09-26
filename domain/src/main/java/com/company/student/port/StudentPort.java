package com.company.student.port;

import com.company.student.model.Student;
import com.company.student.usecase.DeleteStudent;
import com.company.student.usecase.RetrieveStudent;
import com.company.student.usecase.SaveStudent;

public interface StudentPort {
    Student retrieve(RetrieveStudent retrieveStudent);
    Student delete(DeleteStudent deleteStudent);
    Student save(SaveStudent saveStudent);
}
