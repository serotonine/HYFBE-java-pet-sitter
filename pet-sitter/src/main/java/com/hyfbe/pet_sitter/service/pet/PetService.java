package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.pet.PetRequestDTO;
import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import com.hyfbe.pet_sitter.dto.pet.PetUpdateDTO;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.PetMapper;
import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.PetType;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import com.hyfbe.pet_sitter.repository.PetRepository;
import com.hyfbe.pet_sitter.repository.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
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
        Pet pet = prepo.findById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("Pet", id));
        return mapper.toResponseDTO(pet);
    }

    // CREATE
    @Transactional
    public PetResponseDTO addPet(PetRequestDTO dto){

        Long customerId = dto.getCustomer();
        Customer customer = crepo.findById(customerId).orElseThrow(() -> new PetSitterEntityNotFoundException("Customer", customerId));
        Pet pet = new Pet(dto.getName(),customer);

        Long typeId = dto.getType();
        PetType type = ptrepo.findById(typeId).orElseThrow(() -> new PetSitterEntityNotFoundException("PetType", typeId));
        pet.setType(type);

        if(dto.getAge() != null){
            pet.setAge(dto.getAge());
        }
        if(dto.getComment() != null){
            pet.setComment(dto.getComment());
        }
        Pet saved = prepo.save(pet);
        return mapper.toResponseDTO(saved);
    }
    
    // PATCH
    @Transactional
    public PetResponseDTO updatePet(Long id, PetUpdateDTO dto) {
        Pet pet = prepo.findById(id).orElseThrow(() -> new PetSitterEntityNotFoundException("Pet", id));

        String name = dto.getName();
        Long typeId = dto.getTypeId();
        String comment = dto.getComment();
        Integer age = dto.getAge();
        if (name != null) {
            pet.setName(name);
        }
        if (typeId != null) {
            PetType petType = ptrepo.findById(typeId).orElse(null);
            if (petType != null) {
                pet.setType(petType);
            }
        }
        if (age != null) {
            pet.setAge(age);
        }
        if (comment != null) {
            pet.setComment(comment);
        }
        prepo.save(pet);
        return mapper.toResponseDTO(pet);
    }

    // DELETE
    @Transactional
    public PetResponseDTO deletePet( Long id){
        Pet pet = prepo.findById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("Pet", id));
        // Manually remove from customer's list
        Customer customer = pet.getCustomer();
        if (customer != null) {
            customer.removePet(pet);
        }
        prepo.delete(pet);
        return mapper.toResponseDTO(pet);
    }
}
