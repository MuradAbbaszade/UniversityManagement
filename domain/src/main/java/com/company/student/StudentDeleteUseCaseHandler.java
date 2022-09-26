package com.company.student;

import com.company.common.usecase.UseCaseHandler;
import com.company.student.model.Student;
import com.company.student.port.StudentPort;
import com.company.student.usecase.DeleteStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentDeleteUseCaseHandler implements UseCaseHandler<Student, DeleteStudent> {

    private final StudentPort studentPort;

    @Override
    public Student handle(DeleteStudent useCase) throws Exception {
        return studentPort.delete(useCase);
    }
}
