package com.springboot.example.springbootappllication.Appointment;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentServiceId implements Serializable {

    private Long appointmentId;
    private Long doctorId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentServiceId that = (AppointmentServiceId) o;
        return Objects.equals(appointmentId, that.appointmentId) && Objects.equals(doctorId, that.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, doctorId);
    }
}
