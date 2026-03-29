package com.springboot.example.springbootappllication.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findDoctorByNameContainingIgnoreCase(String name);
}
