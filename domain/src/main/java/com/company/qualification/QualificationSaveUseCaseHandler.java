package com.company.qualification;

import com.company.common.usecase.UseCaseHandler;
import com.company.qualification.model.Qualification;
import com.company.qualification.port.QualificationPort;
import com.company.qualification.usecase.SaveQualification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class QualificationSaveUseCaseHandler implements UseCaseHandler<Qualification, SaveQualification> {

    private final QualificationPort qualificationPort;
    @Override
    public Qualification handle(SaveQualification useCase) throws Exception {
        return qualificationPort.save(useCase);
    }
}
