package com.company;

import com.company.adapters.faculty.jpa.FacultyAdapter;
import com.company.adapters.faculty.jpa.repository.FacultyJpaRepository;
import com.company.adapters.group.jpa.GroupAdapter;
import com.company.adapters.group.jpa.repository.GroupJpaRepository;
import com.company.adapters.qualification.jpa.QualificationAdapter;
import com.company.adapters.qualification.jpa.repository.QualificationJpaRepository;
import com.company.adapters.role.jpa.repository.RoleJpaRepository;
import com.company.common.usecase.UseCaseHandler;
import com.company.group.usecase.SaveGroup;
import com.company.student.StudentRetrieveByEmailUseCaseHandler;
import com.company.student.StudentSaveUseCaseHandler;
import com.company.student.model.Student;
import com.company.student.usecase.RetrieveStudent;
import com.company.student.usecase.SaveStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversityManagementApplication {

    @Autowired
            @Qualifier("byEmailStudent")
    private UseCaseHandler<Student, RetrieveStudent> studentRetrieveByEmailUseCaseHandler;
    @Autowired
    private UseCaseHandler<Student, SaveStudent> studentSaveStudentUseCaseHandler;

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }

        };
        return clr;
    }
    public static void main(String[] args){
        SpringApplication.run(UniversityManagementApplication.class);
    }
}
