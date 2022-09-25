package com.company.adapters.faculty.jpa.entity;

import com.company.common.entity.AbstractEntity;
import com.company.faculty.model.Faculty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="faculty",schema = "public")
public class FacultyEntity extends AbstractEntity {
    @Column(name="name")
    private String name;

    public Faculty toModel(){
        return Faculty.builder()
                .id(super.getId())
                .name(name)
                .build();
    }
}
