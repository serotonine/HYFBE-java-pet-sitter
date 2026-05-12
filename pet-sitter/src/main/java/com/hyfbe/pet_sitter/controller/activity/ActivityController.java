package com.hyfbe.pet_sitter.controller.activity;

import com.hyfbe.pet_sitter.dto.activity.ActivityRequestDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityResponseDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityUpdateRequestDTO;
import com.hyfbe.pet_sitter.service.activity.ActivityService;
import com.hyfbe.pet_sitter.service.activity.ActivityService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("api/v1/activity")
public class ActivityController {

    private final ActivityService service;

    public ActivityController(ActivityService service){
        this.service = service;
    }

    // GET
    @GetMapping("")
    public ResponseEntity<List<ActivityResponseDTO>> findAllfindAllActivity(){
        return ResponseEntity.ok().body(service.findAllActivity());
    }

    // ADD
    @PostMapping("")
    public ResponseEntity<ActivityResponseDTO> addActivity(
            @Valid @RequestBody ActivityRequestDTO dto
    ) {
        return ResponseEntity.ok().body(service.addActivity(dto));
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<ActivityResponseDTO> updateActivity(
            @PathVariable Long id,
            @Valid @RequestBody ActivityUpdateRequestDTO dto
    ){
        return ResponseEntity.ok().body(service.updateActivity(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ActivityResponseDTO> updateActivity(
            @PathVariable Long id
    ){
        return ResponseEntity.ok().body(service.deleteActivity(id));
    }
}
