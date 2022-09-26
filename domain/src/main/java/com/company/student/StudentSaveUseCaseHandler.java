package com.company.student;

import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.port.StudentPort;
import com.company.student.usecase.SaveStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentSaveUseCaseHandler implements UseCaseHandler<Student, SaveStudent> {

    private final StudentPort studentPort;

    @Override
    public Student handle(SaveStudent useCase) throws Exception {
        return studentPort.save(useCase);
    }
}
