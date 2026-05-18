package com.hyfbe.pet_sitter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hyfbe.pet_sitter.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name="ps_user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_user_name",
                        columnNames = {"use_name"}
                )

        }
)
@Setter
@Getter
@NoArgsConstructor
public class User {
    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="use_id")
    private Long id;

    // Name
    @Column(name="use_name")
    @NotBlank(message = "Email is required")
    private String name;

    // Password
    @Column(name="use_password")
    @NotBlank(message = "Password is required")
    private String password;

    // USER RELATIONSHIP

    // Customer
    /**
     * Without cascade = CascadeType.ALL
     * See UserService -> addUser
     * tries to save User only.
     * But Customer is still transient.
     * So Hibernate throws exception.
     */
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;

    // Employee
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    private Employee employee;

    // ROLE
    @Enumerated(EnumType.STRING)
    @Column(name="use_role")
    @NotNull
    private Role role = Role.CUSTOMER;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }
}
