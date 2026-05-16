package com.hyfbe.pet_sitter.repository.enrolment;

import com.hyfbe.pet_sitter.model.Employee;
import com.hyfbe.pet_sitter.model.activity.Activity;
import com.hyfbe.pet_sitter.model.enrolment.EmployeeEnrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EmployeeEnrolmentRepository extends JpaRepository<EmployeeEnrolment, Long> {

    boolean existsByEmployeeAndActivity(Employee employee, Activity activity);

    @Query("""
    SELECT a.id FROM EmployeeEnrolment er 
    LEFT JOIN er.activity a
   WHERE a.startDate < :endDate\s
   AND a.endDate > :startDate
      AND er.employee = :employee
    """)
    Optional<Long> employeeEnrolmentOverlap(
            @Param("employee") Employee employee,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

}
