package com.hyfbe.pet_sitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.hyfbe.pet_sitter.model.PetType;

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

    // CONSTRUCTOR
    public Pet(){}
    public Pet(String name, Customer customer){
        this.name = name;
        this.customer = customer;
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
