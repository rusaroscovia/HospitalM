package com.springboot.example.springbootappllication.Doctor;

import com.springboot.example.springbootappllication.Enum.Specialization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * DTO for {@link Doctor}
 */
@Data
public class DoctorDto {

    @NotBlank(message = "Doctor name must not be blank")
    @Length(min = 3, max = 100, message = "Doctor name must be between 3 and 100 characters")
    private String name;

    @NotNull(message = "Specialization must not be null")
    private Specialization specialization;

    @NotNull(message = "Consultation fee must not be null")
    private Double consultationFee;
}
