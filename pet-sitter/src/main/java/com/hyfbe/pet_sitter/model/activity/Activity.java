package com.hyfbe.pet_sitter.model.activity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ps_activity")
@NoArgsConstructor
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="act_id")
    private Long id;

    @NotBlank
    @Column(name="act_name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "at_id",nullable = false)
    private ActivityType type;

    @Column(name="act_start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
    @FutureOrPresent
    private LocalDateTime startDate;
    @Column(name="act_end_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
    @Future
    private LocalDateTime endDate;

    // Enrolments.
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PetEnrolment> petEnrolments = new ArrayList<>();

    // CONSTRUCTOR
    public Activity(String name, ActivityType type, LocalDateTime startDate){
        this.name = name;
        this.type = type;
        this.startDate = startDate;
    }
    // TO STRING
    @Override
    public String toString() {
        return this.getId() + " | "
                + this.getName() + " | "
                + this.getType() + " Start: "
                + this.getStartDate()
                + " End: " + this.getEndDate();
    }
    // Enrolments
    public void addPetEnrolment(PetEnrolment petEnrolment){
        this.petEnrolments.add(petEnrolment);
        petEnrolment.setActivity(this);
    }
    public void deletePetEnrolment(PetEnrolment petEnrolment){
        this.petEnrolments.remove(petEnrolment);
        petEnrolment.setActivity(null);
    }
}
