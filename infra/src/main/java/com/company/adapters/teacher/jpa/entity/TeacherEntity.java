package com.company.adapters.teacher.jpa.entity;

import com.company.adapters.role.jpa.entity.RoleEntity;
import com.company.adapters.subject.jpa.entity.SubjectEntity;
import com.company.common.entity.AbstractEntity;
import com.company.teacher.model.Teacher;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="teacher")
public class TeacherEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleEntity roleEntity;

    @ManyToMany
    private List<SubjectEntity> subjectEntityList;

    public Teacher toModel(){
        return Teacher.builder()
                .id(super.getId())
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .roleId(roleEntity.getId())
                .build();
    }
}
