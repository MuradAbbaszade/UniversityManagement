package com.company.adapters.subject.jpa.repository;

import com.company.adapters.subject.jpa.entity.SubjectEntity;
import com.company.adapters.teacher.jpa.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectJpaRepository extends JpaRepository<SubjectEntity,Long> {
    @Query(value = "select * from subject where name=:name",nativeQuery = true)
    public Optional<SubjectEntity> findByName(@Param("name") String name);
}
