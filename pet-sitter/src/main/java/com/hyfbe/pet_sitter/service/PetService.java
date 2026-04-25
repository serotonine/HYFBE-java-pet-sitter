package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.PetResponseDTO;
import com.hyfbe.pet_sitter.exception.CustomerNotFoundException;
import com.hyfbe.pet_sitter.exception.PetNotFoundException;
import com.hyfbe.pet_sitter.mapper.PetMapper;
import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.PetType;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import com.hyfbe.pet_sitter.repository.PetRepository;
import com.hyfbe.pet_sitter.repository.PetTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {

   private final PetRepository prepo;
   private final PetTypeRepository ptrepo;
   private final CustomerRepository crepo;
   private final PetMapper mapper;

    public PetService(
            PetRepository prepo,
            PetTypeRepository ptrepo,
            CustomerRepository crepo,
            PetMapper mapper){
        this.crepo = crepo;
        this.ptrepo = ptrepo;
        this.prepo = prepo;
        this.mapper = mapper;
    }

    // GET
    public List<PetResponseDTO> findAllPets(){
        List<Pet> pets = prepo.findAll();
        return pets.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    public PetResponseDTO findPetById(Long id) throws PetNotFoundException {
        Pet pet = prepo.findPetById(id).orElseThrow(()-> new PetNotFoundException(id));
        return mapper.toResponseDTO(pet);
    }

    // CREATE
    public PetResponseDTO add(String name, Long customerId, Long typeId, Integer age, byte[] comment){

        Customer customer = crepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
        Pet pet = new Pet(name,customer);

        if(typeId != null){
            PetType type = ptrepo.findById(typeId).orElseThrow(() -> new RuntimeException("No such Pet Type id."));
            pet.setType(type);
        }
        if(age != null){
            pet.setAge(age);
        }
        if(comment != null){
            pet.setComment(comment);
        }
        prepo.save(pet);
        // return PetResponseDTO;
        return mapper.toResponseDTO(pet);
    }
}
