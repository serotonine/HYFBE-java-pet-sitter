package com.hyfbe.pet_sitter.repository;

import com.hyfbe.pet_sitter.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {

}
