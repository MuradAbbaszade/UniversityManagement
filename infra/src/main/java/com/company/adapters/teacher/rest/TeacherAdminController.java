package com.company.adapters.teacher.rest;

import com.company.adapters.teacher.rest.dto.TeacherSaveRequest;
import com.company.common.usecase.UseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.usecase.DeleteTeacher;
import com.company.teacher.usecase.SaveTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/teacher")
public class TeacherAdminController {

    @Autowired
    UseCaseHandler<Teacher, SaveTeacher> saveTeacherUseCaseHandler;
    @Autowired
    UseCaseHandler<Teacher, DeleteTeacher> deleteTeacherUseCaseHandler;

    @PostMapping("delete")
    public ResponseEntity<Teacher> delete(@RequestParam Long id) throws Exception {
        return ResponseEntity.ok(deleteTeacherUseCaseHandler.handle(
                DeleteTeacher.builder().id(id).build()
        ));
    }

    @PostMapping("save")
    public ResponseEntity<Teacher> save(@RequestBody TeacherSaveRequest teacherSaveRequest) throws Exception {
        return ResponseEntity.ok(saveTeacherUseCaseHandler.handle(
                teacherSaveRequest.toUseCase()));
    }
}
