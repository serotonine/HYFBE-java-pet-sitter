package com.hyfbe.pet_sitter.repository;

import com.hyfbe.pet_sitter.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PetRepository extends JpaRepository<Pet, Long> {

}
