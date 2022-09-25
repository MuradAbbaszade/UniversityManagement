package com.company.qualification.usecase;

import com.company.common.model.UseCase;
import com.company.faculty.model.Faculty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveQualification implements UseCase {
    private Long id;
    private String name;
    private Faculty faculty;
}
