package com.hyfbe.pet_sitter.controller.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import com.hyfbe.pet_sitter.repository.enrolment.PetEnrolmentRepository;
import com.hyfbe.pet_sitter.service.enrolment.PetEnrolmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pet/enrolment")
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
    public ResponseEntity<PetEnrolmentResponseDTO> getAllEnrolments(
            @RequestParam Long activity,
            @RequestParam Long pet
    ){
        return ResponseEntity.ok().body(service.addEnrolment(activity,pet));
    }

    // DELETE
}
