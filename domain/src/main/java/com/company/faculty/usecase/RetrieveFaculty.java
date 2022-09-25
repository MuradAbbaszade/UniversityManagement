package com.company.faculty.usecase;

import com.company.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveFaculty implements UseCase {
    private Long id;
}
