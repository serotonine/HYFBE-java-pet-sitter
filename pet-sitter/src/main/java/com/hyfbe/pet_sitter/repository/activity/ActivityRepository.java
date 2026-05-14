package com.hyfbe.pet_sitter.repository.activity;

import com.hyfbe.pet_sitter.model.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query("""
    SELECT DISTINCT a
    FROM Activity a
    LEFT JOIN FETCH a.petEnrolments pe
    LEFT JOIN FETCH a.employeeEnrolments ee
    LEFT JOIN FETCH pe.pet
    LEFT JOIN FETCH ee.employee
    LEFT JOIN FETCH a.type
""")
    List<Activity> findAllComplete();
}
