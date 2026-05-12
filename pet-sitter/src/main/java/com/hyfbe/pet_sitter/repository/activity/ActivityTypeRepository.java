package com.hyfbe.pet_sitter.repository.activity;

import com.hyfbe.pet_sitter.model.activity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
}
