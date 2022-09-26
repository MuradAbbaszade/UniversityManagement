package com.company.teachergroup.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherGroup {
    private Long id;
    private Long teacherId;
    private Long groupId;
    private Long subjectId;
}
