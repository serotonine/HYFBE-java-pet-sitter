package com.hyfbe.pet_sitter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name="ps_customer",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_customer_name_email",
            columnNames = {"cus_name", "cus_email"}
        )
        }
    )
@Getter
@Setter
public class Customer {
    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cus_id")
    private Long id;

    // FIELD NAME
    @Column(name="cus_name", nullable = false, length = 150)
    private String name;

    // FIELD ADDRESS
    @Column(name="cus_address")
    private String address;

    // FIELD TELEPHON
    @Column(name="cus_tel", unique = true, length = 50)
    private String tel;

    // FIELD EMAIL
    @Column(name="cus_email", unique = true, length = 50)
    private String email;

    // FIELD USER
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonBackReference
    private User user;

    // PETS
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    // CONSTRUCTOR
    public Customer(){}
    public Customer(String name){
        this.name = name;
    }

    // User
    public void setUser(User user) {
        this.user = user;

        if (user != null) {
            user.setCustomer(this);
        }
    }
    public void removeUser() {
        if (user != null) {
            user.setCustomer(null);
            user = null;
        }
    }

    // Pets
    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setCustomer(this);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
        pet.setCustomer(null);
    }

}
