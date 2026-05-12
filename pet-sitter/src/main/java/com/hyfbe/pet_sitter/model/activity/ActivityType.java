package com.hyfbe.pet_sitter.model.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyfbe.pet_sitter.enums.AType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ps_activity_type")
@NoArgsConstructor
@Getter
@Setter
public class ActivityType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="at_id")
    private Long id;

    @Column(name = "at_name", nullable = false, unique = true)
    private String name;

    @Column(name="at_desc", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Activity> activities = new ArrayList<>();

    @Column(name = "at_duration", nullable = false)
    private Long durationInMinutes = 60L;

    @Column(name="at_max_dog")
    private Integer maxDog;

    // CONSTRUCTOR
    public ActivityType(String name){
        this.name = name;
    }

    // ACTIVITIES
    public void addActivity(Activity activity) {
        this.activities.add(activity);
        activity.setType(this);
    }

    public void removeActivity(Activity activity) {
        this.activities.remove(activity);
        activity.setType(null);
    }

}
