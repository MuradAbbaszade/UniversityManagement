package com.company.adapters.subject.jpa.entity;

import com.company.adapters.teacher.jpa.entity.TeacherEntity;
import com.company.common.entity.AbstractEntity;
import com.company.subject.model.Subject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name="subject")
public class SubjectEntity extends AbstractEntity {
    @Column(name="name")
    private String name;

    @ManyToMany
    private List<TeacherEntity> teacherEntityList;

    public Subject toModel(){
        return Subject.builder()
                .id(super.getId())
                .name(name)
                .build();
    }
}
