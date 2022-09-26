package com.company.subject;

import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.port.StudentPort;
import com.company.student.usecase.SaveStudent;
import com.company.subject.model.Subject;
import com.company.subject.port.SubjectPort;
import com.company.subject.usecase.SaveSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
    public class SubjectSaveUseCaseHandler implements UseCaseHandler<Subject, SaveSubject> {

    private final SubjectPort subjectPort;


    @Override
    public Subject handle(SaveSubject useCase) throws Exception {
        return subjectPort.save(useCase);
    }
}
