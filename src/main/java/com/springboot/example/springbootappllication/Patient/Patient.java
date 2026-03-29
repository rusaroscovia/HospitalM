package com.springboot.example.springbootappllication.Patient;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Entity
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id", nullable = false)
    private Long id;

    @NotBlank(message = "Patient name must not be blank")
    @Length(min = 3, max = 100, message = "Patient name must be between 3 and 100 characters")
    @Column(name = "patient_name")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email must be valid")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Phone number must not be blank")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull(message = "Age must not be null")
    @Column(name = "age")
    private Integer age;

    @NotBlank(message = "Diagnosis must not be blank")
    @Column(name = "diagnosis")
    private String diagnosis;
}
