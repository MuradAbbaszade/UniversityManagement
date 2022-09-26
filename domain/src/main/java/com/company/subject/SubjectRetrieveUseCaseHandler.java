package com.company.subject;

import com.company.common.usecase.UseCaseHandler;
import com.company.subject.model.Subject;
import com.company.subject.port.SubjectPort;
import com.company.subject.usecase.RetrieveSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SubjectRetrieveUseCaseHandler implements UseCaseHandler<Subject, RetrieveSubject> {

    private final SubjectPort subjectPort;
    @Override
    public Subject handle(RetrieveSubject useCase) throws Exception {
        return subjectPort.retrieve(useCase);
    }
}
