package com.company.adapters.student.rest;

import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.usecase.RetrieveStudent;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController

public class StudentController {
    @Qualifier("byIdStudent")
    @Autowired
    UseCaseHandler<Student, RetrieveStudent> retrieveStudentUseCaseHandler;

    @Qualifier("byEmailStudent")
    @Autowired
    UseCaseHandler<List<Student>,RetrieveStudent> retrieveByEmailStudentUseCaseHandler;

    @Qualifier("byGroupStudent")
    @Autowired
    UseCaseHandler<List<Student>, RetrieveStudent> retrieveByGroupUseCaseHandler;

    @GetMapping("id={id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(retrieveStudentUseCaseHandler.handle(
                RetrieveStudent.builder().id(id).build()));
    }
    @GetMapping("email={email}")
    public ResponseEntity<List<Student>> getStudentByEmail(@PathVariable String email) throws Exception {
        return ResponseEntity.ok(retrieveByEmailStudentUseCaseHandler.handle(
                RetrieveStudent.builder().email(email).build()));
    }
    @GetMapping("groupId={groupId}")
    public ResponseEntity<List<Student>> getStudentByGroup(@PathVariable Long groupId) throws Exception {
        return ResponseEntity.ok(retrieveByGroupUseCaseHandler.handle(
                RetrieveStudent.builder().groupId(groupId).build()));
    }

}
