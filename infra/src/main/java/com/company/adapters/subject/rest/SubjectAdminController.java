package com.company.adapters.subject.rest;

import com.company.adapters.subject.rest.dto.SubjectSaveRequest;
import com.company.common.usecase.UseCaseHandler;
import com.company.subject.model.Subject;
import com.company.subject.usecase.DeleteSubject;
import com.company.subject.usecase.RetrieveSubject;
import com.company.subject.usecase.SaveSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/subject")
public class SubjectAdminController {

    @Autowired
    UseCaseHandler<Subject, SaveSubject> saveSubjectUseCaseHandler;

    @Autowired
    UseCaseHandler<Subject, RetrieveSubject> retrieveSubjectUseCaseHandler;

    @Autowired
    UseCaseHandler<Subject, DeleteSubject> deleteSubjectUseCaseHandler;

    @PostMapping("save")
    public Subject save(@RequestBody SubjectSaveRequest subjectSaveRequest) throws Exception {
        return saveSubjectUseCaseHandler.handle(subjectSaveRequest.toUseCase());
    }

    @PostMapping("delete")
    public Subject delete(@RequestParam Long id) throws Exception {
        Subject subject = retrieveSubjectUseCaseHandler.handle(
                RetrieveSubject.builder().id(id).build()
        );
        deleteSubjectUseCaseHandler.handle(DeleteSubject.builder().id(id).build());
        return subject;
    }
}
