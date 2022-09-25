package com.company.adapters.qualification.rest.dto;

import com.company.faculty.model.Faculty;
import com.company.faculty.usecase.SaveFaculty;
import com.company.qualification.usecase.SaveQualification;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QualificationSaveRequest {

    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Faculty faculty;

    public SaveQualification toUseCase() {
        return SaveQualification.builder()
                .id(id)
                .name(name)
                .faculty(faculty)
                .build();
    }
}
