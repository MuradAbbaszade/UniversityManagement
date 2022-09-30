package com.company.student.usecase;

import com.company.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveStudent implements UseCase {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer acceptancePoint;
    private Long groupId;
    private Long roleId;
}
