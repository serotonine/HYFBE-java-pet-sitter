package com.hyfbe.pet_sitter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ps_employee")
// Lombok annotations.
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="em_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    // FIELD NAME
    @Column(name="em_name", nullable = false, unique = true, length = 150)
    private String name;

    // FIELD ADDRESS
    @Column(name="em_address")
    private String address;

    // FIELD TELEPHONE
    @Column(name="em_tel", unique = true, length = 50)
    private String tel;

    // FIELD EMAIL
    @Column(name="em_email", unique = true, length = 50)
    @NotNull
    private String email;

    // FIELD USER
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonBackReference
    private User user;

    public Employee(String name, String email){
        this.name = name;
        this.email= email;
    }

    // User
    public void setUser(User user) {
        this.user = user;

        if (user != null) {
            user.setEmployee(this);
        }
    }
    public void removeUser() {
        if (user != null) {
            user.setEmployee(null);
            user = null;
        }
    }

}
