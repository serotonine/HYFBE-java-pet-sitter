package com.hyfbe.pet_sitter.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="ps_pet_type")
public class PetType {
    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pt_id")
    private Long id;

    @Column(name="pt_name", nullable = false, unique = true, length = 100)
    private String name;

   /* @OneToMany(mappedBy = "type")
    private List<Pet> pets;*/

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
   /* public List<Pet> getPets() { return pets; }
    public void setPets(List<Pet> pets) { this.pets = pets; }*/

}
