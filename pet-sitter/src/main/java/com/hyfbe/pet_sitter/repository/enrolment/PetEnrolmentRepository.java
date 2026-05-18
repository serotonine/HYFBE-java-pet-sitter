package com.hyfbe.pet_sitter.repository.enrolment;

import com.hyfbe.pet_sitter.model.Employee;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.activity.Activity;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PetEnrolmentRepository extends JpaRepository<PetEnrolment, Long> {
    boolean existsByPetAndActivity(Pet pet, Activity activity);
    Integer countPetEnrolmentsByActivity(Activity activity);

    @Query("""
    SELECT a.id FROM PetEnrolment pr 
    LEFT JOIN pr.activity a
   WHERE a.startDate < :endDate\s
   AND a.endDate > :startDate
      AND pr.pet = :pet
    """)
    Optional<Long> petEnrolmentOverlap(
            @Param("pet") Pet pet,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);
}
