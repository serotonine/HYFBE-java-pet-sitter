package com.hyfbe.pet_sitter.model;

import jakarta.persistence.*;

@Entity
@Table(name="ps_pet_type")
public class PetType {
    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FIELD NAME (E.g Victor De La Motte)
    @Column(name="pt_name", nullable = false, unique = true, length = 100)
    private String name;

    public PetType(){}

    public PetType(String name) {
        this.name = name;
    }

    // GETTERS AND SETTERS.
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
