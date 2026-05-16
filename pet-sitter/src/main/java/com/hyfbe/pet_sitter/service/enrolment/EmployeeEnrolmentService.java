package com.hyfbe.pet_sitter.service.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.enrolment.EmployeeEnrolmentMapper;
import com.hyfbe.pet_sitter.mapper.enrolment.PetEnrolmentMapper;
import com.hyfbe.pet_sitter.model.Employee;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.activity.Activity;
import com.hyfbe.pet_sitter.model.enrolment.EmployeeEnrolment;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import com.hyfbe.pet_sitter.repository.EmployeeRepository;
import com.hyfbe.pet_sitter.repository.PetRepository;
import com.hyfbe.pet_sitter.repository.activity.ActivityRepository;
import com.hyfbe.pet_sitter.repository.enrolment.EmployeeEnrolmentRepository;
import com.hyfbe.pet_sitter.repository.enrolment.PetEnrolmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmployeeEnrolmentService {
    private final EmployeeEnrolmentRepository repo;
    private final EmployeeRepository eRepo;
    private final ActivityRepository activityRepo;
   private final EmployeeEnrolmentMapper mapper;

    // GET
    @Transactional(readOnly = true)
    public
    List<EmployeeEnrolmentResponseDTO> getAllEnrolments(){
        return repo.findAll().stream().map(mapper::toResponseDTO).toList();
    }

    // POST
    @Transactional
    public EmployeeEnrolmentResponseDTO addEnrolment(Long activityId, Long employeeId ){
        Employee employee = eRepo.findById(employeeId).orElseThrow(()-> new PetSitterEntityNotFoundException("Employee", employeeId));
       Activity activity = activityRepo.findById(activityId).orElseThrow(()-> new PetSitterEntityNotFoundException("Activity", activityId));
       // Check if dupplicate.
        if(repo.existsByEmployeeAndActivity(employee, activity)){
            throw new DuplicateKeyException("This employee is already enrolled in this activity");
        }
        //Check if the employee is already enroled in an overlap activity.
        Optional<Long> overlap =  repo.employeeEnrolmentOverlap(employee, activity.getStartDate(), activity.getEndDate());
        if(overlap.isPresent()){
            throw new DuplicateKeyException("This employee is already enrolled in activity " + overlap);
        }
       EmployeeEnrolment ee = new EmployeeEnrolment(activity, employee);

        activity.addEmployeeEnrolment(ee);
        EmployeeEnrolment saved = repo.save(ee);
        return mapper.toResponseDTO(saved);
    }
}
