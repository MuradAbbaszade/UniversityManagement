package com.company.adapters.student.rest;

import com.company.adapters.student.rest.dto.StudentSaveRequest;
import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.usecase.DeleteStudent;
import com.company.student.usecase.RetrieveStudent;
import com.company.student.usecase.SaveStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/student")
public class StudentAdminController {

    @Autowired
    UseCaseHandler<Student, SaveStudent> saveStudentUseCaseHandler;

    @Autowired
    UseCaseHandler<Student, DeleteStudent> deleteStudentUseCaseHandler;

    @Qualifier("byIdStudent")
    @Autowired
    UseCaseHandler<Student, RetrieveStudent> retrieveStudentUseCaseHandler;


    @PostMapping("save")
    public ResponseEntity<Student> save(@RequestBody StudentSaveRequest studentSaveRequest) throws Exception {
        return ResponseEntity.ok(saveStudentUseCaseHandler.handle(
                studentSaveRequest.toUseCase()
        ));
    }
    @PostMapping("delete")
    public ResponseEntity<Student> delete(@RequestParam Long id) throws Exception {
        return ResponseEntity.ok(deleteStudentUseCaseHandler.handle(
                DeleteStudent.builder().id(id).build()));
    }
}
