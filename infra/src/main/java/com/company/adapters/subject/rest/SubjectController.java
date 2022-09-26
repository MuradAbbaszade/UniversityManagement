package com.company.adapters.subject.rest;

import com.company.common.usecase.UseCaseHandler;
import com.company.subject.model.Subject;
import com.company.subject.usecase.RetrieveSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    UseCaseHandler<Subject, RetrieveSubject> retrieveSubjectUseCaseHandler;

    @GetMapping("{id}")
    public Subject retrieve(@PathVariable Long id) throws Exception {
        return retrieveSubjectUseCaseHandler.handle(
                RetrieveSubject.builder().id(id).build());
    }

}
