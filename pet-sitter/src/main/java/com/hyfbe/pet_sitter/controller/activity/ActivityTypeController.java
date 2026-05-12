package com.hyfbe.pet_sitter.controller.activity;

import com.hyfbe.pet_sitter.dto.activity.ActivityTypeRequestDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityTypeResponseDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityTypeUpdateRequestDTO;
import com.hyfbe.pet_sitter.service.activity.ActivityTypeService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("api/v1/activity_type")
public class ActivityTypeController {

    private final ActivityTypeService service;

    public ActivityTypeController(ActivityTypeService service){
        this.service = service;
    }

    // GET
    @GetMapping("")
    public ResponseEntity<List<ActivityTypeResponseDTO>> findAllfindAllActivityType(){
        return ResponseEntity.ok().body(service.findAllActivityType());
    }

    // ADD
    @PostMapping("")
    public ResponseEntity<ActivityTypeResponseDTO> addActivityType(
            @Valid @RequestBody ActivityTypeRequestDTO dto
    ) {
        return ResponseEntity.ok().body(service.addActivityType(dto));
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<ActivityTypeResponseDTO> updateActivityType(
            @PathVariable Long id,
            @Valid @RequestBody ActivityTypeUpdateRequestDTO dto
    ){
        return ResponseEntity.ok().body(service.updateActivityType(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ActivityTypeResponseDTO> updateActivityType(
            @PathVariable Long id
    ){
        return ResponseEntity.ok().body(service.deleteActivityType(id));
    }
}
