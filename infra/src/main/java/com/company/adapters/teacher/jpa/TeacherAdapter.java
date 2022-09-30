package com.company.adapters.teacher.jpa;

import com.company.adapters.role.jpa.repository.RoleJpaRepository;
import com.company.adapters.student.jpa.entity.StudentEntity;
import com.company.adapters.teacher.jpa.entity.TeacherEntity;
import com.company.adapters.teacher.jpa.repository.TeacherJpaRepository;
import com.company.student.model.Student;
import com.company.teacher.model.Teacher;
import com.company.teacher.port.TeacherPort;
import com.company.teacher.usecase.DeleteTeacher;
import com.company.teacher.usecase.RetrieveTeacher;
import com.company.teacher.usecase.SaveTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherAdapter implements TeacherPort {

    private final TeacherJpaRepository teacherJpaRepository;
    private final RoleJpaRepository roleJpaRepository;
    @Override
    public Teacher retrieve(RetrieveTeacher retrieveTeacher) throws Exception {
        return teacherJpaRepository.findById(retrieveTeacher.getId())
                .map(TeacherEntity::toModel)
                .orElseThrow(()->new Exception("Teacher not found"));
    }

    @Override
    public List<Teacher> retrieveByEmail(RetrieveTeacher retrieveTeacher) throws Exception {
        if(retrieveTeacher.getEmail()!=null && !(retrieveTeacher.getEmail().isEmpty())) {
            return Arrays.asList(teacherJpaRepository.findByEmail(retrieveTeacher.getEmail())
                    .map(TeacherEntity::toModel)
                    .orElseThrow(() -> new Exception("Teacher not found")));
        }
        List<TeacherEntity> teacherEntities = teacherJpaRepository.findAll();
        List<Teacher> teachers = new ArrayList<>();
        for(TeacherEntity teacherEntity : teacherEntities){
            teachers.add(teacherEntity.toModel());
        }
        return teachers;
    }

    @Override
    public Teacher delete(DeleteTeacher deleteTeacher) throws Exception {
        Teacher teacher = teacherJpaRepository.findById(deleteTeacher.getId())
                .map(TeacherEntity::toModel)
                .orElseThrow(()->new Exception("Teacher not found"));
        teacherJpaRepository.deleteById(deleteTeacher.getId());
        return teacher;
    }

    @Override
    public Teacher save(SaveTeacher saveTeacher) {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(saveTeacher.getId());
        teacherEntity.setName(saveTeacher.getName());
        teacherEntity.setSurname(saveTeacher.getSurname());
        teacherEntity.setEmail(saveTeacher.getEmail());
        teacherEntity.setPassword(passwordEncoder().encode(saveTeacher.getPassword()));
        teacherEntity.setRoleEntity(roleJpaRepository.findById(saveTeacher.getRoleId()).get());
        return teacherJpaRepository.save(teacherEntity).toModel();
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
