package com.hyfbe.pet_sitter.service.activity;

import com.hyfbe.pet_sitter.dto.activity.*;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.activity.ActivityMapper;
import com.hyfbe.pet_sitter.model.activity.Activity;
import com.hyfbe.pet_sitter.model.activity.ActivityType;
import com.hyfbe.pet_sitter.repository.activity.ActivityRepository;
import com.hyfbe.pet_sitter.repository.activity.ActivityTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class ActivityService {
    private final ActivityRepository repo;
    private final ActivityTypeRepository atrepo;
    private final ActivityMapper mapper;

    // GET
    @Transactional(readOnly = true)
    public List<ActivityResponseDTO> findAllActivity(){
        List<Activity> list = repo.findAllComplete();
        list.forEach(act-> log.info(act.getPetEnrolments()));
        return repo.findAllComplete().stream().map(mapper::toResponseDTO).toList();
       // return repo.findAll().stream().map(mapper::toResponseDTO).toList();
    }

    // POST
    public ActivityResponseDTO addActivity(ActivityRequestDTO dto){
        // Retrieve dto fields.
        String name = dto.getName();
        // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime start = dto.getStartDate();
        Long typeId = dto.getTypeId();
        // Get ActivityType Entity.
        ActivityType type = atrepo.findById(typeId).orElseThrow(() -> new PetSitterEntityNotFoundException("ActivityType", typeId));
        // Set Activity Entity.
        Activity activity = new Activity(name, type, start );
       // activity fields
        LocalDateTime end = start.plusMinutes(type.getDurationInMinutes());
        activity.setEndDate(end);
        Activity saved = repo.save(activity);
        return mapper.toResponseDTO(saved);
        // TODO CREATE ENROLMENT
    }

    // PATCH
    public ActivityResponseDTO updateActivity(Long id, ActivityUpdateRequestDTO dto){
        Activity activity = repo.findById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("Activity", id));

        // Change name manually
        if(dto.getName() !=null){
            activity.setName(dto.getName());
        }

        // Change type if any.
        if(dto.getTypeId() !=null){
            ActivityType type = atrepo.findById(dto.getTypeId()).orElseThrow(() -> new PetSitterEntityNotFoundException("ActivityType", dto.getTypeId()));
            activity.setType(type);
        }
        if(dto.getStartDate() !=null){
            LocalDateTime start = dto.getStartDate();
            activity.setStartDate(start);
            Long duration = activity.getType().getDurationInMinutes();
            LocalDateTime end = activity.getStartDate().plusMinutes(duration);
            activity.setEndDate(end);
        }
        Activity saved = repo.save(activity);
        log.info("After save: " + saved.toString());
        return mapper.toResponseDTO(saved);
    }

    // DELETE
    public ActivityResponseDTO deleteActivity(Long id){
        Activity activity = repo.findById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("Activity", id));
        repo.delete(activity);
        return mapper.toResponseDTO(activity);
    }
}
