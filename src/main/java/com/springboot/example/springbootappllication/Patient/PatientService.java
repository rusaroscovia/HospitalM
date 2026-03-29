package com.springboot.example.springbootappllication.Patient;

import com.springboot.example.springbootappllication.Exceptions.PatientNotFound;
import com.springboot.example.springbootappllication.Response.AddResponse;
import com.springboot.example.springbootappllication.Response.UpdateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public AddResponse addPatient(PatientDto patientDto) {
        patientRepository.save(patientMapper.mapToEntity(patientDto));
        return new AddResponse(patientDto.getName() + " successfully added", HttpStatus.ACCEPTED);
    }

    public Patient getPatient(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFound("No patient found with such id", id));
    }

    public Patient getPatient(String name) {
        return patientRepository.findPatientByNameContainingIgnoreCase(name)
                .orElseThrow(() -> new PatientNotFound("No patient found with the provided name", name));
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public UpdateResponse updatePatient(String name, PatientDto patientDto) {
        var patientToUpdate = patientRepository.findPatientByNameContainingIgnoreCase(name)
                .orElseThrow(() -> new PatientNotFound("No patient found", name));

        patientRepository.save(patientMapper.updateEntity(patientDto, patientToUpdate));

        return new UpdateResponse(patientToUpdate.getName(), patientDto.getName(), "successfully updated");
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
