package com.hyfbe.pet_sitter.controller.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.service.enrolment.EmployeeEnrolmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee/enrolment")
@RequiredArgsConstructor
public class EmployeeEnrolmentController {

    private final EmployeeEnrolmentService service;


    // GET
    @GetMapping("")
    public ResponseEntity<List<EmployeeEnrolmentResponseDTO>> getAllEnrolments(){
        return ResponseEntity.ok().body(service.getAllEnrolments());
    }

    // POST
    @PostMapping("")
    public ResponseEntity<EmployeeEnrolmentResponseDTO> addEnrolment(
            @RequestParam Long activity,
            @RequestParam Long employee
    ){
        EmployeeEnrolmentResponseDTO created = service.addEnrolment(activity,employee);
        return ResponseEntity.created(URI.create("/api/v1/employee/enrolment/" + created.getEnrolmentId())).body(created);

    }

    // DELETE
}
