package com.company.adapters.student.rest;

import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.usecase.RetrieveStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Qualifier("byIdStudent")
    @Autowired
    UseCaseHandler<Student, RetrieveStudent> retrieveStudentUseCaseHandler;

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(retrieveStudentUseCaseHandler.handle(
                RetrieveStudent.builder().id(id).build()));
    }

}
