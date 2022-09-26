package com.company.teacher;

import com.company.common.usecase.UseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.port.TeacherPort;
import com.company.teacher.usecase.DeleteTeacher;
import com.company.teacher.usecase.RetrieveTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherDeleteUseCaseHandler implements UseCaseHandler<Teacher, DeleteTeacher> {

    private final TeacherPort teacherPort;
    @Override
    public Teacher handle(DeleteTeacher useCase) throws Exception {
        return teacherPort.delete(useCase);
    }
}

