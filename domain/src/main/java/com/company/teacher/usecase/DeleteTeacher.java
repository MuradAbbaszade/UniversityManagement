package com.company.teacher.usecase;

import com.company.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteTeacher implements UseCase {
    private Long id;
}
