package com.springboot.example.springbootappllication.Doctor;

import com.springboot.example.springbootappllication.Response.AddResponse;
import com.springboot.example.springbootappllication.Response.UpdateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public AddResponse addDoctor(DoctorDto doctorDto) {
        doctorRepository.save(doctorMapper.mapToEntity(doctorDto));
        return new AddResponse(doctorDto.getName() + " successfully added", HttpStatus.ACCEPTED);
    }

    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No doctor found with id: " + id));
    }

    public Doctor getDoctor(String name) {
        return doctorRepository.findDoctorByNameContainingIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("No doctor found with name: " + name));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public UpdateResponse updateDoctor(String name, DoctorDto doctorDto) {
        var doctorToUpdate = doctorRepository.findDoctorByNameContainingIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("No doctor found with name: " + name));

        doctorRepository.save(doctorMapper.updateEntity(doctorDto, doctorToUpdate));

        return new UpdateResponse(doctorToUpdate.getName(), doctorDto.getName(), "successfully updated");
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
