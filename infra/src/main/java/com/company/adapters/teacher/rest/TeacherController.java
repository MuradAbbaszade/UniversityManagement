package com.company.adapters.teacher.rest;

import com.company.common.usecase.UseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.usecase.RetrieveTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Qualifier("byIdTeacher")
    @Autowired
    UseCaseHandler<Teacher, RetrieveTeacher> retrieveTeacherUseCaseHandler;

    @Qualifier("byEmailTeacher")
    @Autowired
    UseCaseHandler<List<Teacher>, RetrieveTeacher> retrieveByEmailTeacherUseCaseHandler;

    @Qualifier("bySubjectTeacher")
    @Autowired
    UseCaseHandler<List<Teacher>, RetrieveTeacher> retrieveBySubjectTeacherUseCaseHandler;

    @GetMapping("id={id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(retrieveTeacherUseCaseHandler.handle(
                RetrieveTeacher.builder().id(id).build()));
    }
    @GetMapping("email={email}")
    public ResponseEntity<List<Teacher>> getTeacherByEmail(@PathVariable String email) throws Exception {
        return ResponseEntity.ok(retrieveByEmailTeacherUseCaseHandler.handle(
                RetrieveTeacher.builder().email(email).build()));
    }
    @GetMapping("subjectId={subjectId}")
    public ResponseEntity<List<Teacher>> getTeacherByEmail(@PathVariable Long subjectId) throws Exception {
        return ResponseEntity.ok(retrieveBySubjectTeacherUseCaseHandler.handle(
                RetrieveTeacher.builder().subjectId(subjectId).build()));
    }
}
