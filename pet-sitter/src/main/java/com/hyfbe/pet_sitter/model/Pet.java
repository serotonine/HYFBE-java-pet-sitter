package com.hyfbe.pet_sitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import jakarta.persistence.*;
import com.hyfbe.pet_sitter.model.PetType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ps_pet")
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
    @Column(name="pet_comment", length = 255)
    private byte[] comment;

    // Enrolment.
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PetEnrolment> petEnrolments = new ArrayList<>();

    // CONSTRUCTOR
    public Pet(){}
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

    // GETTERS.

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Integer getAge() {
        return age;
    }

    public PetType getType() {
        return type;
    }

    public byte[] getComment(){
        return comment;
    }

    // SETTERS.

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public void setComment(byte[] comment) {
        this.comment = comment;
    }
}
