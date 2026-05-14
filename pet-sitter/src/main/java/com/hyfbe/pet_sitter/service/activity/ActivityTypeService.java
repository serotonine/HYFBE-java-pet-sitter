package com.hyfbe.pet_sitter.service.activity;

import com.hyfbe.pet_sitter.dto.activity.ActivityTypeRequestDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityTypeResponseDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityTypeUpdateRequestDTO;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.activity.ActivityTypeMapper;
import com.hyfbe.pet_sitter.model.activity.ActivityType;
import com.hyfbe.pet_sitter.repository.activity.ActivityTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ActivityTypeService {
    private final ActivityTypeRepository repo;
    private final ActivityTypeMapper mapper;

    // GET
    @Transactional(readOnly = true)
    public List<ActivityTypeResponseDTO> findAllActivityType(){
        return repo.findAll().stream().map(mapper::toResponseDTO).toList();
    }

    // POST
    public ActivityTypeResponseDTO addActivityType(ActivityTypeRequestDTO dto){
        ActivityType at = mapper.toEntity(dto);
        ActivityType saved = repo.save(at);
        return mapper.toResponseDTO(saved);
    }

    // PATCH
    public ActivityTypeResponseDTO updateActivityType(Long id, ActivityTypeUpdateRequestDTO dto){
        ActivityType activityType = repo.findById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("ActivityType", id));
        mapper.updateEntityFromDTO(dto, activityType);
        ActivityType saved = repo.save(activityType);
        return mapper.toResponseDTO(saved);
    }

    // DELETE
    public ActivityTypeResponseDTO deleteActivityType(Long id){
        ActivityType activityType = repo.findById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("ActivityType", id));
        repo.delete(activityType);
        return mapper.toResponseDTO(activityType);
    }
}
