package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.PetType;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import com.hyfbe.pet_sitter.repository.PetRepository;
import com.hyfbe.pet_sitter.repository.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    PetRepository prepo;
    @Autowired
    PetTypeRepository ptrepo;
    @Autowired
    CustomerRepository crepo;


    public PetService(){

    }

    // GET
    public ResponseEntity<List<Pet>> getAllPets(){
        return ResponseEntity.ok().body(prepo.findAll());
    }

    // CREATE
    public ResponseEntity<?> add(String name, Long customerId, Long typeId, Integer age, byte[] comment){
        Optional<Customer> customer = crepo.findById(customerId);
        if(customer.get() == null){
            return ResponseEntity.notFound().build();
        }
        Pet pet = new Pet(name,customer.get());


        if(typeId != null){
            Optional<PetType> type = ptrepo.findById(typeId);
            pet.setType(type.get());
        }
        if(age != null){
            pet.setAge(age);
        }
        if(comment != null){
            pet.setComment(comment);
        }
        prepo.save(pet);
        return ResponseEntity.ok().body(pet);
    }
}
