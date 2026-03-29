package com.springboot.example.springbootappllication.Appointment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRequest {
    private Long doctorId;
    private Integer sessions;
}
