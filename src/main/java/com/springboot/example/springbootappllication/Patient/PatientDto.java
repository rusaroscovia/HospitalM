package com.springboot.example.springbootappllication.Patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * DTO for {@link Patient}
 */
@Data
public class PatientDto {

    @NotBlank(message = "Patient name must not be blank")
    @Length(min = 3, max = 100, message = "Patient name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Phone number must not be blank")
    private String phoneNumber;

    @NotNull(message = "Age must not be null")
    private Integer age;

    @NotBlank(message = "Diagnosis must not be blank")
    private String diagnosis;
}
