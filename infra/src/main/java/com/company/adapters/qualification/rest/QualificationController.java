package com.company.adapters.qualification.rest;

import com.company.common.usecase.UseCaseHandler;
import com.company.qualification.model.Qualification;
import com.company.qualification.usecase.RetrieveQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qualification")
public class QualificationController {

    @Autowired
    UseCaseHandler<Qualification, RetrieveQualification> useCaseHandler;

    @GetMapping("{id}")
    public ResponseEntity<Qualification> getQualification(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(useCaseHandler.
                handle(RetrieveQualification.builder().id(id).build()));
    }
}
