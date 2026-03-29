package com.springboot.example.springbootappllication.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentServiceRepository extends JpaRepository<AppointmentService, AppointmentServiceId> {
}
