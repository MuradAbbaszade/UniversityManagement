package com.company.faculty;

import com.company.common.usecase.UseCaseHandler;
import com.company.faculty.model.Faculty;
import com.company.faculty.port.FacultyPort;
import com.company.faculty.usecase.DeleteFaculty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FacultyDeleteUseCaseHandler implements UseCaseHandler<Faculty,DeleteFaculty> {

    private final FacultyPort facultyPort;

    @Override
    public Faculty handle(DeleteFaculty useCase) throws Exception {
        return facultyPort.delete(useCase);
    }
}
