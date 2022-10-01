package com.company.teacher;

import com.company.common.usecase.UseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.port.TeacherPort;
import com.company.teacher.usecase.RetrieveTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component("bySubjectTeacher")
public class TeacherRetrieveBySubject implements UseCaseHandler<List<Teacher>, RetrieveTeacher> {

    private final TeacherPort teacherPort;
    @Override
    public List<Teacher> handle(RetrieveTeacher useCase) throws Exception {
        return teacherPort.retrieveBySubject(useCase);
    }
}
