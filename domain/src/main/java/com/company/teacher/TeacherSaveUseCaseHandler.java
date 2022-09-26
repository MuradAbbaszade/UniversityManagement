package com.company.teacher;

import com.company.common.usecase.UseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.port.TeacherPort;
import com.company.teacher.usecase.SaveTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherSaveUseCaseHandler implements UseCaseHandler<Teacher, SaveTeacher> {

    private final TeacherPort teacherPort;
    @Override
    public Teacher handle(SaveTeacher useCase) throws Exception {
        return teacherPort.save(useCase);
    }
}
