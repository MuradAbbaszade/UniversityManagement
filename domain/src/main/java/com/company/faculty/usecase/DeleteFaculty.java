package com.company.faculty.usecase;

import com.company.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteFaculty implements UseCase {
    private Long id;
}
