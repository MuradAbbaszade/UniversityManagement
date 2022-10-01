package com.company.adapters.group.jpa.entity;

import com.company.adapters.qualification.jpa.entity.QualificationEntity;
import com.company.adapters.student.jpa.entity.StudentEntity;
import com.company.common.entity.AbstractEntity;
import com.company.group.model.Group;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="group",schema = "public")
@ToString
public class GroupEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="year")
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "qualification_id", referencedColumnName = "id")
    private QualificationEntity qualificationEntity;
    @OneToMany(mappedBy = "groupEntity")
    private List<StudentEntity> studentEntityList;

    public Group toModel(){
        return Group.builder()
                .id(super.getId())
                .name(name)
                .year(year)
                .qualificationId(qualificationEntity.getId())
                .build();
    }
}
