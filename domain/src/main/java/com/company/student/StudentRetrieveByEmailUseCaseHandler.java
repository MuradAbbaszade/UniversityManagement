package com.company.student;

import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.port.StudentPort;
import com.company.student.usecase.RetrieveStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("byEmailStudent")
@RequiredArgsConstructor
public class StudentRetrieveByEmailUseCaseHandler implements UseCaseHandler<List<Student>, RetrieveStudent> {

    private final StudentPort studentPort;

    @Override
    public List<Student> handle(RetrieveStudent useCase) throws Exception {
        return studentPort.retrieveByEmail(useCase);
    }
}