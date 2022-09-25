package com.company;

import com.company.adapters.faculty.jpa.FacultyAdapter;
import com.company.adapters.faculty.jpa.repository.FacultyJpaRepository;
import com.company.adapters.qualification.jpa.QualificationAdapter;
import com.company.faculty.model.Faculty;
import com.company.faculty.usecase.RetrieveFaculty;
import com.company.faculty.usecase.SaveFaculty;
import com.company.qualification.usecase.RetrieveQualification;
import com.company.qualification.usecase.SaveQualification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversityManagementApplication {

    @Autowired
    FacultyAdapter facultyAdapter;

    @Autowired
    FacultyJpaRepository facultyJpaRepository;

    @Autowired
    QualificationAdapter qualificationAdapter;

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
