package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.PetMapper;
import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.PetType;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import com.hyfbe.pet_sitter.repository.PetRepository;
import com.hyfbe.pet_sitter.repository.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

   private final PetRepository prepo;
   private final PetTypeRepository ptrepo;
   private final CustomerRepository crepo;
   private final PetMapper mapper;

    // GET
    @Transactional(readOnly = true)
    public List<PetResponseDTO> findAllPets(){
        List<Pet> pets = prepo.findAll();
        return pets.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public PetResponseDTO findPetById(Long id){
        Pet pet = prepo.findPetById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("Pet", id));
        return mapper.toResponseDTO(pet);
    }

    // CREATE
    public PetResponseDTO add(String name, Long customerId, Long typeId, Integer age, byte[] comment){

        Customer customer = crepo.findById(customerId).orElseThrow(() -> new PetSitterEntityNotFoundException("Customer", customerId));
        Pet pet = new Pet(name,customer);

        if(typeId != null){
            PetType type = ptrepo.findById(typeId).orElseThrow(() -> new PetSitterEntityNotFoundException("PetType", typeId));
            pet.setType(type);
        }
        if(age != null){
            pet.setAge(age);
        }
        if(comment != null){
            pet.setComment(comment);
        }
        prepo.save(pet);
        return mapper.toResponseDTO(pet);
    }
}
