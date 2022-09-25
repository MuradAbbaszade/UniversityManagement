package com.company.group.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Group {
    private Long id;
    private String name;
    private Integer year;
    private Long qualificationId;
}
