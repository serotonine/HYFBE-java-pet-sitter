package com.hyfbe.pet_sitter.controller.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.model.enrolment.EmployeeEnrolment;
import com.hyfbe.pet_sitter.service.enrolment.EmployeeEnrolmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee/enrolment")
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
    public ResponseEntity<EmployeeEnrolmentResponseDTO> getAllEnrolments(
            @RequestParam Long activity,
            @RequestParam Long employee
    ){
        return ResponseEntity.ok().body(service.addEnrolment(activity,employee));
    }

    // DELETE
}
