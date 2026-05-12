package com.hyfbe.pet_sitter.service.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.enrolment.PetEnrolmentMapper;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.activity.Activity;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import com.hyfbe.pet_sitter.repository.PetRepository;
import com.hyfbe.pet_sitter.repository.activity.ActivityRepository;
import com.hyfbe.pet_sitter.repository.enrolment.PetEnrolmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetEnrolmentService {
    private final PetEnrolmentRepository repo;
    private final PetRepository petRepo;
    private final ActivityRepository activityRepo;
    private final PetEnrolmentMapper mapper;

    // GET
    @Transactional(readOnly = true)
    public
    List<PetEnrolmentResponseDTO> getAllEnrolments(){
        return repo.findAll().stream().map(mapper::toResponseDTO).toList();
    }

    // POST
    public PetEnrolment addEnrolment(Long activityId,Long petId ){
        Pet pet = petRepo.findById(petId).orElseThrow(()-> new PetSitterEntityNotFoundException("Pet", petId));
       Activity activity = activityRepo.findById(activityId).orElseThrow(()-> new PetSitterEntityNotFoundException("Activity", petId));
        PetEnrolment pe = new PetEnrolment(activity, pet);
        activity.addPetEnrolment(pe);
        return repo.save(pe);
    }
}
