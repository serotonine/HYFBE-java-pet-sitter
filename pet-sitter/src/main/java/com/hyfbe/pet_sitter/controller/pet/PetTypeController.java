package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.dto.pet.PetRequestDTO;
import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import com.hyfbe.pet_sitter.dto.pet.PetUpdateDTO;
import com.hyfbe.pet_sitter.service.PetService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;


import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
@Log4j2
public class PetController {

    private final PetService service;

    public PetController(PetService service){
        this.service = service;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> findAllPets(){
        List<PetResponseDTO> response = service.findAllPets();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponseDTO> findPetById(@PathVariable Long id) {
        var response = service.findPetById(id);
        return ResponseEntity.ok().body(response);
    }

    // ADD
    @PostMapping
    public ResponseEntity<PetResponseDTO> addPet(
            @Valid @RequestBody PetRequestDTO dto
    ) {
        PetResponseDTO created = service.addPet(dto);
        return ResponseEntity.created(URI.create("/api/v1/pet/" + created.getId())).body(created);
    }
    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<PetResponseDTO> updatePet(
            @PathVariable Long id,
            @Valid @RequestBody PetUpdateDTO dto
            ){
        PetResponseDTO updated = service.updatePet(id, dto);
        log.info("DTO PET UPDATED : " + updated.getComment());
        return ResponseEntity.ok().body(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<PetResponseDTO> deletePet(
            @PathVariable Long id
    ){
        PetResponseDTO deleted = service.deletePet(id);
        return ResponseEntity.ok().body(deleted);
    }
}
