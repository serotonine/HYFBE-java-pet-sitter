package com.hyfbe.pet_sitter.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ps_customer")
public class Customer {
    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FIELD NAME (E.g Victor De La Motte)
    @Column(name="cus_name", nullable = false, unique = true, length = 150)
    private String name;

    // FIELD ADDRESS (E.g 5 rue Motte, 1050 Bruxelles)
    @Column(name="cus_address")
    private String address;

    @Column(name="cus_tel", unique = true, length = 50)
    private String tel;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    // Constructor.
    public Customer(){}
    public Customer(String name){
        this.name = name;
    }
    // GETTERS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public List<Pet> getPets() {
        return pets;
    }
    // SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
