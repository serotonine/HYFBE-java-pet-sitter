package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import com.hyfbe.pet_sitter.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService service){
        this.petService = service;
    }

    // GET
    @GetMapping("")
    public ResponseEntity<List<PetResponseDTO>> findAllPets(){
        List<PetResponseDTO> response = petService.findAllPets();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponseDTO> findPetById(@PathVariable Long id) {
        var response = petService.findPetById(id);
        return ResponseEntity.ok().body(response);
    }

    // ADD
    @PostMapping("")
    public PetResponseDTO addPet(
            @RequestParam String name,
            @RequestParam Long customer,
            @RequestParam(required = false) Long type,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) byte[] comment
    ) {
        return petService.add(name, customer, type, age, comment);
    }
}
