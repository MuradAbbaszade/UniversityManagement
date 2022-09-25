package com.company.group.usecase;

import com.company.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveGroup implements UseCase {
    private Long id;
}
