package com.company.student;

import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.port.StudentPort;
import com.company.student.usecase.RetrieveStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component("byQualificationStudent")
public class StudentRetrieveByQualificationUseCaseHandler implements UseCaseHandler<List<Student>, RetrieveStudent> {

    private final StudentPort studentPort;
    @Override
    public List<Student> handle(RetrieveStudent useCase) throws Exception {
        return studentPort.retrieveByQualification(useCase);
    }
}
