package com.company.adapters.student.rest;

import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.usecase.RetrieveStudent;
import com.company.teacher.usecase.RetrieveTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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

    @Qualifier("byQualificationStudent")
    @Autowired
    UseCaseHandler<List<Student>, RetrieveStudent> retrieveByQualificationUseCaseHandler;

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
    @GetMapping("groupName={groupName}")
    public ResponseEntity<List<Student>> getStudentByGroup(@PathVariable String groupName) throws Exception {
        return ResponseEntity.ok(retrieveByGroupUseCaseHandler.handle(
                RetrieveStudent.builder().groupName(groupName).build()));
    }
    @GetMapping("qualificationName={qualificationName}")
    public ResponseEntity<List<Student>> getStudentByQualification(@PathVariable String qualificationName) throws Exception {
        return ResponseEntity.ok(retrieveByQualificationUseCaseHandler.handle(
                RetrieveStudent.builder().qualificationName(qualificationName).build()));
    }

}
