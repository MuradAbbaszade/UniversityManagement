package com.company.adapters.student.jpa.entity;

import com.company.adapters.group.jpa.entity.GroupEntity;
import com.company.common.entity.AbstractEntity;
import com.company.student.model.Student;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="student",schema = "public")
public class StudentEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="acceptance_point")
    private Integer acceptancePoint;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private GroupEntity groupEntity;

    public Student toModel(){
        return Student.builder()
                .id(super.getId())
                .name(name)
                .surname(surname)
                .acceptencePoint(acceptancePoint)
                .groupId(groupEntity.getId())
                .build();
    }
}
