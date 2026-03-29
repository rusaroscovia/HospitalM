package com.springboot.example.springbootappllication.Appointment;

import com.springboot.example.springbootappllication.Doctor.Doctor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "appointment_service")
public class AppointmentService {

    @EmbeddedId
    private AppointmentServiceId id;

    @ManyToOne
    @MapsId("appointmentId")
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    @MapsId("doctorId")
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    // number of sessions booked with this doctor
    private Integer sessions;

    private Double totalFee;
}
