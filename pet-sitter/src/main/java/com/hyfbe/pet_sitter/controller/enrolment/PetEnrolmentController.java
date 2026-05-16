package com.hyfbe.pet_sitter.controller.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.service.enrolment.PetEnrolmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pet/enrolment")
@RequiredArgsConstructor
public class PetEnrolmentController {

    private final PetEnrolmentService service;


    // GET
    @GetMapping("")
    public ResponseEntity<List<PetEnrolmentResponseDTO>> getAllEnrolments(){
        return ResponseEntity.ok().body(service.getAllEnrolments());
    }

    // POST
    @PostMapping("")
    public ResponseEntity<PetEnrolmentResponseDTO> addEnrolment(
            @RequestParam Long activity,
            @RequestParam Long pet
    ){
        PetEnrolmentResponseDTO created = service.addEnrolment(activity,pet);
        return ResponseEntity.created(URI.create("/api/v1/pet/enrolment/" + created.getEnrolmentId())).body(created);
    }

    // DELETE
}
