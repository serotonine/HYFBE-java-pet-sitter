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
    @Column(name="cus_id")
    private Long id;

    // FIELD NAME
    @Column(name="cus_name", nullable = false, unique = true, length = 150)
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

    // CONSTRUCTOR
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

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        this.email = email;
    }
}
