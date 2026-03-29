package com.springboot.example.springbootappllication.Appointment;

import com.springboot.example.springbootappllication.Patient.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @CreationTimestamp
    private LocalDateTime appointmentDate;

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
    private List<AppointmentService> services = new ArrayList<>();
}
