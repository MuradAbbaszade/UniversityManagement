package com.company.faculty;

import com.company.common.usecase.UseCaseHandler;
import com.company.faculty.model.Faculty;
import com.company.faculty.port.FacultyPort;
import com.company.faculty.usecase.RetrieveFaculty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FacultyRetrieveUseCaseHandler implements UseCaseHandler<Faculty, RetrieveFaculty> {

    private final FacultyPort facultyPort;

    @Override
    public Faculty handle(RetrieveFaculty useCase) throws Exception {
        return facultyPort.retrieve(useCase);
    }
}
