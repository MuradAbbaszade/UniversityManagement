package com.company.adapters.teacher.jpa.repository;

import com.company.adapters.teacher.jpa.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherJpaRepository extends JpaRepository<TeacherEntity,Long> {

    @Query(value = "select * from teacher where email=:email",nativeQuery = true)
    public Optional<TeacherEntity> findByEmail(@Param("email") String email);
}
