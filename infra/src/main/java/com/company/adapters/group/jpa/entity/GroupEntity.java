package com.company.adapters.group.jpa.entity;

import com.company.adapters.qualification.jpa.entity.QualificationEntity;
import com.company.common.entity.AbstractEntity;
import com.company.group.model.Group;
import com.company.qualification.model.Qualification;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

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

    public Group toModel(){
        return Group.builder()
                .id(super.getId())
                .name(name)
                .year(year)
                .qualificationId(qualificationEntity.getId())
                .build();
    }
}
