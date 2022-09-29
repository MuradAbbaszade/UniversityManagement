package com.company.adapters.role.jpa.entity;

import com.company.adapters.student.jpa.entity.StudentEntity;
import com.company.adapters.teacher.jpa.entity.TeacherEntity;
import com.company.common.entity.AbstractEntity;
import com.company.role.model.Role;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="role",schema = "public")
@ToString
public class RoleEntity extends AbstractEntity {
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "roleEntity")
    private List<StudentEntity> studentEntityList;

    @OneToMany(mappedBy = "roleEntity")
    private List<TeacherEntity> teacherEntityList;

    public Role toModel(){
        return Role.builder()
                .id(super.getId())
                .name(name)
                .build();
    }
}
