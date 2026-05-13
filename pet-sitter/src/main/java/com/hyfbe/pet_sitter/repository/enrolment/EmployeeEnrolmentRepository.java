package com.hyfbe.pet_sitter.repository.enrolment;

import com.hyfbe.pet_sitter.model.enrolment.EmployeeEnrolment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeEnrolmentRepository extends JpaRepository<EmployeeEnrolment, Long> {
}
