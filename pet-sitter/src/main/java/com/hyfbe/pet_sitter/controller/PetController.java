package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import com.hyfbe.pet_sitter.exception.PetNotFoundException;
import com.hyfbe.pet_sitter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService service){
        this.petService = service;
    }

    // GET
    @GetMapping("")
    public List<PetResponseDTO> findAllPets(){
        return petService.findAllPets();
    }
    @GetMapping("/{id}")
    public PetResponseDTO findPetById(@PathVariable Long id) throws PetNotFoundException {
        var response = petService.findPetById(id);
        return response;
    }

    // ADD
    @PostMapping("/add")
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
