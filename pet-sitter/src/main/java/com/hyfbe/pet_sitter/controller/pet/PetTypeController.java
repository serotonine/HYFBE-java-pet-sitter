package com.hyfbe.pet_sitter.controller.pet;

import com.hyfbe.pet_sitter.dto.pet.PetTypeResponseDTO;
import com.hyfbe.pet_sitter.service.pet.PetTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-type")
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
}
