package com.hyfbe.pet_sitter.model;

import jakarta.persistence.*;

@Entity
@Table(name="ps_pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FIELD NAME (E.g Victor De La Motte)
    @Column(name="pet_name", nullable = false, unique = true, length = 150)
    private String name;

    // FIELD customer
    @ManyToOne
    @JoinColumn(name="cus_id")
    private Customer customer;

    // FIELD age
    @Column(name="pet_age")
    private Integer age;

    // FIELD type
    @OneToOne
    @JoinColumn(name="pt_id")
    private PetType type;

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
}
