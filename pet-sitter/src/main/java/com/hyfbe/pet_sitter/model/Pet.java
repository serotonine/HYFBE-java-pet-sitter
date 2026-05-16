package com.hyfbe.pet_sitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import jakarta.persistence.*;
import com.hyfbe.pet_sitter.model.PetType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ps_pet")
@Getter
@Setter
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pet_id")
    private Long id;

    // FIELD NAME
    @Column(name="pet_name", nullable = false, unique = true, length = 150)
    private String name;

    // FIELD customer
    @ManyToOne
    @JoinColumn(name="cus_id", nullable = false)
    @JsonIgnore
    private Customer customer;

    // FIELD age
    @Column(name="pet_age")
    private Integer age;

    // FIELD type
    @ManyToOne
    @JoinColumn(name="pt_id")
    private PetType type;

    //FIELD comments
    @Column(name="pet_comment", columnDefinition = "TEXT",  length = 500)
    private String comment;

    // Enrolment.
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PetEnrolment> petEnrolments = new ArrayList<>();

    // CONSTRUCTOR
    public Pet(String name, Customer customer){
        this.name = name;
        this.customer = customer;
    }

    // Enrolments
    public void addPetEnrolment(PetEnrolment petEnrolment){
        this.petEnrolments.add(petEnrolment);
        petEnrolment.setPet(this);
    }
    public void deletePetEnrolment(PetEnrolment petEnrolment){
        this.petEnrolments.remove(petEnrolment);
        petEnrolment.setPet(null);
    }
}
