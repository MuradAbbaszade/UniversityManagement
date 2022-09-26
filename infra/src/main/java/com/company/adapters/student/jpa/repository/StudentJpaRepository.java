package com.company.adapters.student.jpa.repository;

import com.company.adapters.student.jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity,Long> {
}
