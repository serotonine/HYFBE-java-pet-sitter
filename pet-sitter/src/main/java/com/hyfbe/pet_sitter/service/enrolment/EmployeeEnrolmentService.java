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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
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
    public EmployeeEnrolment addEnrolment(Long activityId, Long employeeId ){
        Employee employee = eRepo.findById(employeeId).orElseThrow(()-> new PetSitterEntityNotFoundException("Employee", employeeId));
       Activity activity = activityRepo.findById(activityId).orElseThrow(()-> new PetSitterEntityNotFoundException("Activity", employeeId));
        EmployeeEnrolment ee = new EmployeeEnrolment(activity, employee);
        activity.addEmployeeEnrolment(ee);
        return repo.save(ee);
    }
}
