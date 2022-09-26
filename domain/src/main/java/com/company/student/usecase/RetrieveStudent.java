package com.company.student.usecase;

import com.company.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveStudent implements UseCase {
    private Long id;
}
