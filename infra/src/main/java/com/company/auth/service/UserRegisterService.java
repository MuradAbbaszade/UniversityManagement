package com.company.auth.service;
import com.company.student.StudentSaveUseCaseHandler;
import com.company.student.model.Student;
import com.company.student.usecase.SaveStudent;
import com.company.teacher.TeacherSaveUseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.usecase.SaveTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService implements IUserRegisterService{

    @Autowired
    StudentSaveUseCaseHandler studentSaveUseCaseHandler;
    @Autowired
    TeacherSaveUseCaseHandler teacherSaveUseCaseHandler;

    @Override
    public Student registerStudent(Student student) throws Exception {
        return studentSaveUseCaseHandler.handle(SaveStudent.builder()
        .id(student.getGroupId())
        .name(student.getName())
        .surname(student.getSurname())
        .password(student.getPassword())
        .email(student.getEmail())
        .acceptencePoint(student.getAcceptencePoint())
        .groupId(student.getGroupId())
        .build());
    }

    @Override
    public Teacher registerTeacher(Teacher teacher) throws Exception {
        return teacherSaveUseCaseHandler.handle(SaveTeacher.builder()
        .id(teacher.getId())
        .name(teacher.getName())
        .surname(teacher.getSurname())
        .email(teacher.getEmail())
        .password(teacher.getPassword())
        .build());
    }
}
