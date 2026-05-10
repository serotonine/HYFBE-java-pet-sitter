package com.hyfbe.pet_sitter.model;

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
    @OneToOne(mappedBy = "customer")
    private User user;

    // CONSTRUCTOR
    public Customer(){}
    public Customer(String name){
        this.name = name;
    }

}
