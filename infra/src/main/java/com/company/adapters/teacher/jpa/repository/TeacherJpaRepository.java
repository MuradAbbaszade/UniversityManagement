package com.company.adapters.teacher.jpa.repository;

import com.company.adapters.teacher.jpa.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherJpaRepository extends JpaRepository<TeacherEntity,Long> {
}
