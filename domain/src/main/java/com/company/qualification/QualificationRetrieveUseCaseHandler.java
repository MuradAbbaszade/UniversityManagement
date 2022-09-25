package com.company.qualification;

import com.company.common.usecase.UseCaseHandler;
import com.company.qualification.model.Qualification;
import com.company.qualification.port.QualificationPort;
import com.company.qualification.usecase.RetrieveQualification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class QualificationRetrieveUseCaseHandler implements UseCaseHandler<Qualification, RetrieveQualification>{

    private final QualificationPort qualificationPort;
    @Override
    public Qualification handle(RetrieveQualification useCase) throws Exception {
        return qualificationPort.retrieveQualification(useCase);
    }
}
