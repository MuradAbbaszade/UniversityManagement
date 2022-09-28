package com.company.auth.service;

import com.company.common.usecase.UseCaseHandler;
import javax.transaction.Transactional;

import com.company.student.model.Student;
import com.company.student.usecase.RetrieveStudent;
import com.company.teacher.model.Teacher;
import com.company.teacher.usecase.RetrieveTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Qualifier("byEmailStudent")
    @Autowired
    private UseCaseHandler<Student, RetrieveStudent> retrieveStudentUseCaseHandler;
    @Qualifier("byEmailTeacher")
    @Autowired
    private UseCaseHandler<Teacher, RetrieveTeacher> retrieveTeacherUseCaseHandler;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try{
            Student student = retrieveStudentUseCaseHandler.handle(
                RetrieveStudent.builder().email(email).build());
            UserBuilder builder = User.withUsername(email);
            builder.disabled(false);
            builder.password(student.getPassword());
            builder.authorities("STUDENT");
            return builder.build();
        }
        catch(Exception e){
            try{
            Teacher teacher = retrieveTeacherUseCaseHandler.handle(
                    RetrieveTeacher.builder().email(email).build());
                UserBuilder builder = User.withUsername(email);
                builder.disabled(false);
                builder.password(teacher.getPassword());
                builder.authorities("TEACHER");
                return builder.build();
            }
            catch(Exception ex){
                throw new UsernameNotFoundException("Email or password incorrect.");
            }
        }
    }
}
