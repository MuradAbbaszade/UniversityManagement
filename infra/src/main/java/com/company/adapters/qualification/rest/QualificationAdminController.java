package com.company.adapters.qualification.rest;

import com.company.adapters.qualification.rest.dto.QualificationSaveRequest;
import com.company.common.usecase.UseCaseHandler;
import com.company.qualification.QualificationDeleteUseCaseHandler;
import com.company.qualification.model.Qualification;
import com.company.qualification.usecase.DeleteQualification;
import com.company.qualification.usecase.RetrieveQualification;
import com.company.qualification.usecase.SaveQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/qualification")
public class QualificationAdminController {

    @Autowired
    UseCaseHandler<Qualification, DeleteQualification> deleteQualificationUseCaseHandler;

    @Autowired
    UseCaseHandler<Qualification, SaveQualification> saveQualificationUseCaseHandler;

    @Autowired
    UseCaseHandler<Qualification, RetrieveQualification> retrieveQualificationUseCaseHandler;

    @PostMapping("save")
    public Qualification saveQualification(@RequestBody QualificationSaveRequest qualificationSaveRequest) throws Exception {
        return saveQualificationUseCaseHandler.handle(qualificationSaveRequest.toUseCase());
    }
    @PostMapping("delete")
    public Qualification deleteQualification(@RequestParam Long id) throws Exception {
        Qualification qualification = retrieveQualificationUseCaseHandler.handle(
                RetrieveQualification.builder().id(id).build());
        deleteQualificationUseCaseHandler.handle(DeleteQualification.builder().id(id).build());
        return qualification;
    }

}
