package com.company.faculty;

import com.company.common.usecase.UseCaseHandler;
import com.company.faculty.model.Faculty;
import com.company.faculty.port.FacultyPort;
import com.company.faculty.usecase.SaveFaculty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FacultySaveUseCaseHandler implements UseCaseHandler<Faculty, SaveFaculty> {

    private final FacultyPort facultyPort;
    @Override
    public Faculty handle(SaveFaculty useCase) {
        return facultyPort.saveFaculty(useCase);
    }
}
