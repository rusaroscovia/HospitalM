package com.springboot.example.springbootappllication.Appointment;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppointmentRequest {
    private Long patientId;
    private List<DoctorRequest> doctors;
}
