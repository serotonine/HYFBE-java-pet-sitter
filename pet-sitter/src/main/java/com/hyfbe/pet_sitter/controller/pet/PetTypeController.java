package com.hyfbe.pet_sitter.controller.pet;

import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import com.hyfbe.pet_sitter.dto.pet.PetTypeResponseDTO;
import com.hyfbe.pet_sitter.service.pet.PetTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-type")
@Log4j2
public class PetTypeController {

    private final PetTypeService service;

    public PetTypeController(PetTypeService service){
        this.service = service;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<PetTypeResponseDTO>> findAllPetTypes(){
        List<PetTypeResponseDTO> response = service.findAllPetTypes();
        return ResponseEntity.ok().body(response);
    }

   /* @GetMapping("/{id}")
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
    }*/
}
