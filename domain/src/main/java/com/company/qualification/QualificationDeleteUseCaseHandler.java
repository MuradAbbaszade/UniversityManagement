package com.company.qualification;

import com.company.common.usecase.UseCaseHandler;
import com.company.qualification.model.Qualification;
import com.company.qualification.port.QualificationPort;
import com.company.qualification.usecase.DeleteQualification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class QualificationDeleteUseCaseHandler implements UseCaseHandler<Qualification, DeleteQualification> {

    private final QualificationPort qualificationPort;
    @Override
    public Qualification handle(DeleteQualification useCase) throws Exception {
        return qualificationPort.delete(useCase);
    }
}
