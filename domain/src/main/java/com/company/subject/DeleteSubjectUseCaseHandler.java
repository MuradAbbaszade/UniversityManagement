package com.company.subject;

import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.port.StudentPort;
import com.company.student.usecase.SaveStudent;
import com.company.subject.model.Subject;
import com.company.subject.port.SubjectPort;
import com.company.subject.usecase.DeleteSubject;
import com.company.subject.usecase.SaveSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteSubjectUseCaseHandler implements UseCaseHandler<Subject, DeleteSubject> {

    private final SubjectPort subjectPort;
    @Override
    public Subject handle(DeleteSubject useCase) throws Exception {
        return subjectPort.delete(useCase);
    }
}
