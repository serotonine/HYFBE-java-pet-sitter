package com.hyfbe.pet_sitter.model.enrolment;

import com.hyfbe.pet_sitter.model.Employee;
import com.hyfbe.pet_sitter.model.activity.Activity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name="ps_employee_enrolment",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_ee_activity_employee",
                        columnNames = {"ee_employee_id", "ee_activity_id"}
                )
        })

@NoArgsConstructor
@Getter
@Setter
public class EmployeeEnrolment {
    @Id
    @Column(name="ee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ee_employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ee_activity_id")
    private Activity activity;

    public EmployeeEnrolment(Activity activity, Employee employee ){
        this.activity = activity;
        this.employee = employee;
    }
}
