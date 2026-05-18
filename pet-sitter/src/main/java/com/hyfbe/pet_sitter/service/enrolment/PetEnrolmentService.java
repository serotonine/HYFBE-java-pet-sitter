package com.hyfbe.pet_sitter.service.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.exception.PetSitterEntityActivityMaxPetException;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.enrolment.PetEnrolmentMapper;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.activity.Activity;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import com.hyfbe.pet_sitter.repository.PetRepository;
import com.hyfbe.pet_sitter.repository.activity.ActivityRepository;
import com.hyfbe.pet_sitter.repository.enrolment.PetEnrolmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public PetEnrolmentResponseDTO addEnrolment(Long activityId,Long petId ) {
        Pet pet = petRepo.findById(petId).orElseThrow(()-> new PetSitterEntityNotFoundException("Pet", petId));
        Activity activity = activityRepo.findById(activityId).orElseThrow(()-> new PetSitterEntityNotFoundException("Activity", activityId));
        // Chek max pet.
        if (activity.getType().getMaxDog() == repo.countPetEnrolmentsByActivity(activity)){
            throw new PetSitterEntityActivityMaxPetException();
        }
        // Check if duplicate.
        if(repo.existsByPetAndActivity(pet, activity)){
            throw new DuplicateKeyException("This pet is already enroled in this activity.");
        }
        // Check if the employee is already enroled in an overlap activity.
        Optional<Long> overlap =  repo.petEnrolmentOverlap(pet, activity.getStartDate(), activity.getEndDate());
        if(overlap.isPresent()){
            throw new DuplicateKeyException("This pet is already enrolled in activity " + overlap.get());
        }
        PetEnrolment pe = new PetEnrolment(activity, pet);
        activity.addPetEnrolment(pe);
        PetEnrolment saved =  repo.save(pe);
        return mapper.toResponseDTO(saved);
    }
}
