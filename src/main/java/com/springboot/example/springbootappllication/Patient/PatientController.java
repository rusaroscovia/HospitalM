package com.springboot.example.springbootappllication.Patient;

import com.springboot.example.springbootappllication.Response.AddResponse;
import com.springboot.example.springbootappllication.Response.UpdateResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AddResponse> createPatient(@Valid @RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(service.addPatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return new ResponseEntity<>(service.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getPatient(id), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<Patient> getPatientByName(@RequestParam String name) {
        return new ResponseEntity<>(service.getPatient(name), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UpdateResponse> updatePatient(@Valid @RequestBody PatientDto patientDto,
                                                        @RequestParam String name) {
        return new ResponseEntity<>(service.updatePatient(name, patientDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
