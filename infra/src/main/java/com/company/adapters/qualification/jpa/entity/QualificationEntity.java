package com.company.adapters.qualification.jpa.entity;

import com.company.adapters.faculty.jpa.entity.FacultyEntity;
import com.company.common.entity.AbstractEntity;
import com.company.qualification.model.Qualification;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="qualification",schema = "public")
public class QualificationEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    @ManyToOne
    private FacultyEntity facultyEntity;

    public Qualification toModel(){
        return Qualification.builder()
                .id(super.getId())
                .name(name)
                .facultyId(facultyEntity.getId())
                .build();
    }
}
