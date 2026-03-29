package com.springboot.example.springbootappllication.Doctor;

import com.springboot.example.springbootappllication.Response.AddResponse;
import com.springboot.example.springbootappllication.Response.UpdateResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AddResponse> createDoctor(@Valid @RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(service.addDoctor(doctorDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<>(service.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getDoctor(id), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<Doctor> getDoctorByName(@RequestParam String name) {
        return new ResponseEntity<>(service.getDoctor(name), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UpdateResponse> updateDoctor(@Valid @RequestBody DoctorDto doctorDto,
                                                       @RequestParam String name) {
        return new ResponseEntity<>(service.updateDoctor(name, doctorDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        service.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
