package com.company.adapters.faculty.jpa.entity;

import com.company.adapters.qualification.jpa.entity.QualificationEntity;
import com.company.common.entity.AbstractEntity;
import com.company.faculty.model.Faculty;
import com.company.qualification.model.Qualification;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@Table(name="faculty",schema = "public")
public class FacultyEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "facultyEntity",fetch=EAGER)
    private List<QualificationEntity> qualificationEntityList;

    public Faculty toModel(){
        return Faculty.builder()
                .id(super.getId())
                .name(name)
                .build();
    }
}
