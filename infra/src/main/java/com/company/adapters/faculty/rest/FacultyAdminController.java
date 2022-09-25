package com.company.adapters.faculty.rest;

import com.company.adapters.faculty.rest.dto.FacultySaveRequest;
import com.company.common.usecase.UseCaseHandler;
import com.company.faculty.model.Faculty;
import com.company.faculty.usecase.DeleteFaculty;
import com.company.faculty.usecase.RetrieveFaculty;
import com.company.faculty.usecase.SaveFaculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/faculty")
public class FacultyAdminController {

    @Autowired
    private UseCaseHandler<Faculty, SaveFaculty> saveFacultyUseCaseHandler;

    @Autowired
    private UseCaseHandler<Faculty, DeleteFaculty> deleteFacultyUseCaseHandler;

    @Autowired
    private UseCaseHandler<Faculty, RetrieveFaculty> retrieveFacultyUseCaseHandler;

    @PostMapping("save")
    public ResponseEntity<Faculty> saveFaculty(
            @Valid @RequestBody FacultySaveRequest facultySaveRequest) throws Exception {
            return ResponseEntity.ok(saveFacultyUseCaseHandler.handle(facultySaveRequest.toUseCase()));
    }
    @PostMapping("delete")
    public ResponseEntity<Faculty> deleteFaculty(@RequestParam Long id) throws Exception {
        Faculty faculty = retrieveFacultyUseCaseHandler.handle(RetrieveFaculty.builder().id(id).build());
        deleteFacultyUseCaseHandler.handle(DeleteFaculty.builder().id(id).build());
        return ResponseEntity.ok(faculty);
    }
}