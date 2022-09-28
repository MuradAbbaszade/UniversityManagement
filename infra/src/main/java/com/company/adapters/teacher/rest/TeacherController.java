package com.company.adapters.teacher.rest;

import com.company.common.usecase.UseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.usecase.RetrieveTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Qualifier("byIdTeacher")
    @Autowired
    UseCaseHandler<Teacher, RetrieveTeacher> retrieveTeacherUseCaseHandler;

    @GetMapping("{id}")
    public Teacher retrieve(@PathVariable Long id) throws Exception {
        return retrieveTeacherUseCaseHandler.handle(
                RetrieveTeacher.builder().id(id).build());
    }
}
