package com.hyfbe.pet_sitter.repository.enrolment;

import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetEnrolmentRepository extends JpaRepository<PetEnrolment, Long> {
}
