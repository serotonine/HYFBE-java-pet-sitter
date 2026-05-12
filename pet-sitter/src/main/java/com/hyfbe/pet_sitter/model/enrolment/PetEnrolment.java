package com.hyfbe.pet_sitter.model.enrolment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.activity.Activity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name="ps_pet_enrolment",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_pe_activity_pet",
                        columnNames = {"pe_pet_id", "pe_activity_id"}
                )
        })

@NoArgsConstructor
@Getter
@Setter
public class PetEnrolment {
    @Id
    @Column(name="pe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pe_pet_id")
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pe_activity_id")
    @JsonIgnore
    private Activity activity;

    public PetEnrolment(Activity activity,Pet pet ){
        this.activity = activity;
        this.pet = pet;
    }
}
