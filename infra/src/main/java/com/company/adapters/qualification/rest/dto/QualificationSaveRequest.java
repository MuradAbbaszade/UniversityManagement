package com.company.adapters.qualification.rest.dto;

import com.company.adapters.faculty.jpa.FacultyAdapter;
import com.company.faculty.usecase.RetrieveFaculty;
import com.company.qualification.usecase.SaveQualification;
import com.sun.istack.NotNull;
import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
public class QualificationSaveRequest {

    private final FacultyAdapter facultyAdapter;

    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long facultyId;

    public SaveQualification toUseCase() throws Exception {
        return SaveQualification.builder()
                .id(id)
                .name(name)
                .faculty(facultyAdapter.retrieve(RetrieveFaculty.builder().id(id).build()))
                .build();
    }
}
