package com.hyfbe.pet_sitter.service.pet;


import com.hyfbe.pet_sitter.dto.pet.PetTypeResponseDTO;
import com.hyfbe.pet_sitter.mapper.PetTypeMapper;
import com.hyfbe.pet_sitter.model.PetType;
import com.hyfbe.pet_sitter.repository.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetTypeService {

   private final PetTypeRepository repo;
   private final PetTypeMapper mapper;

    // GET
    @Transactional(readOnly = true)
    public List<PetTypeResponseDTO> findAllPetTypes(){
        List<PetType> types = repo.findAll();
        return types.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }
   /* @Transactional(readOnly = true)
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
    }*/
}
