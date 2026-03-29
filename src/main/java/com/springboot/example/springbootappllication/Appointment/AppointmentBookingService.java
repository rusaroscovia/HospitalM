package com.springboot.example.springbootappllication.Appointment;

import com.springboot.example.springbootappllication.Doctor.Doctor;
import com.springboot.example.springbootappllication.Doctor.DoctorRepository;
import com.springboot.example.springbootappllication.Patient.Patient;
import com.springboot.example.springbootappllication.Patient.PatientRepository;
import com.springboot.example.springbootappllication.Response.AddResponse;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentBookingService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentBookingService(PatientRepository patientRepository,
                                     DoctorRepository doctorRepository,
                                     AppointmentRepository appointmentRepository,
                                     AppointmentMapper appointmentMapper) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Transactional
    public AddResponse createAppointment(AppointmentRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = appointmentMapper.toAppointment(patient);

        List<AppointmentService> services = new ArrayList<>();

        for (DoctorRequest doctorRequest : request.getDoctors()) {
            Doctor doctor = doctorRepository.findById(doctorRequest.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));

            double totalFee = doctor.getConsultationFee() * doctorRequest.getSessions();

            AppointmentService service = appointmentMapper.toAppointmentService(
                    appointment, doctor, doctorRequest.getSessions(), totalFee);

            AppointmentServiceId serviceId = new AppointmentServiceId();
            serviceId.setAppointmentId(appointment.getId());
            serviceId.setDoctorId(doctor.getId());
            service.setId(serviceId);

            services.add(service);
        }

        appointment.setServices(services);
        appointmentRepository.save(appointment);

        return new AddResponse("Appointment for " + patient.getName() + " successfully booked", HttpStatus.ACCEPTED);
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
