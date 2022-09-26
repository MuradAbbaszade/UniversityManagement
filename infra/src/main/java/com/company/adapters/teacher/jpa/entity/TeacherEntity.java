package com.company.adapters.teacher.jpa.entity;

import com.company.adapters.subject.jpa.entity.SubjectEntity;
import com.company.common.entity.AbstractEntity;
import com.company.teacher.model.Teacher;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name="teacher")
public class TeacherEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;

    @ManyToMany
    private List<SubjectEntity> subjectEntityList;

    public Teacher toModel(){
        return Teacher.builder()
                .id(super.getId())
                .name(name)
                .surname(surname)
                .build();
    }
}
