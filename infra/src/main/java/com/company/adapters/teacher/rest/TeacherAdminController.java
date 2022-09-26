package com.company.adapters.teacher.rest;

import com.company.adapters.teacher.rest.dto.TeacherSaveRequest;
import com.company.common.usecase.UseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.usecase.DeleteTeacher;
import com.company.teacher.usecase.RetrieveTeacher;
import com.company.teacher.usecase.SaveTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/teacher")
public class TeacherAdminController {

    @Autowired
    UseCaseHandler<Teacher, SaveTeacher> saveTeacherUseCaseHandler;
    @Autowired
    UseCaseHandler<Teacher, DeleteTeacher> deleteTeacherUseCaseHandler;
    @Autowired
    UseCaseHandler<Teacher, RetrieveTeacher> retrieveTeacherUseCaseHandler;

    @PostMapping("delete")
    public Teacher delete(@RequestParam Long id) throws Exception {
        Teacher teacher = retrieveTeacherUseCaseHandler.handle(
                RetrieveTeacher.builder().id(id).build()
        );
        deleteTeacherUseCaseHandler.handle(
                DeleteTeacher.builder().id(id).build()
        );
        return teacher;
    }

    @PostMapping("save")
    public Teacher save(@RequestBody TeacherSaveRequest teacherSaveRequest) throws Exception {
        return saveTeacherUseCaseHandler.handle(
                teacherSaveRequest.toUseCase()
        );
    }
}
