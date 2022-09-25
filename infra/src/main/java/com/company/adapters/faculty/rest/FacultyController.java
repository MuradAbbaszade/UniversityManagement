package com.company.adapters.faculty.rest;

import com.company.common.usecase.UseCaseHandler;
import com.company.faculty.model.Faculty;
import com.company.faculty.usecase.RetrieveFaculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private UseCaseHandler<Faculty,RetrieveFaculty> useCaseHandler;

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) throws Exception {
        RetrieveFaculty retrieveFaculty = RetrieveFaculty.builder()
                .id(id)
                .build();
        return ResponseEntity.ok(useCaseHandler.handle(retrieveFaculty));
    }
}
