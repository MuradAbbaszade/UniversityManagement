package com.company.teacher;

import com.company.common.usecase.UseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.port.TeacherPort;
import com.company.teacher.usecase.RetrieveTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherRetrieveUseCaseHandler implements UseCaseHandler<Teacher, RetrieveTeacher> {

    private final TeacherPort teacherPort;
    @Override
    public Teacher handle(RetrieveTeacher useCase) throws Exception {
        return teacherPort.retrieve(useCase);
    }
}
