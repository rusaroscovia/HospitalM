package com.springboot.example.springbootappllication.Doctor;

import com.springboot.example.springbootappllication.Enum.Specialization;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id", nullable = false)
    private Long id;

    @Column(name = "doctor_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Column(name = "consultation_fee")
    private Double consultationFee;
}
