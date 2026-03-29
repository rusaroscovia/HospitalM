package com.springboot.example.springbootappllication.Appointment;

import com.springboot.example.springbootappllication.Doctor.Doctor;
import com.springboot.example.springbootappllication.Patient.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "services", ignore = true)
    @Mapping(target = "appointmentDate", ignore = true)
    Appointment toAppointment(Patient patient);

    @Mapping(target = "id", ignore = true)
    AppointmentService toAppointmentService(Appointment appointment, Doctor doctor, Integer sessions, Double totalFee);
}
