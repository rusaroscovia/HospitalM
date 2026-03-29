package com.springboot.example.springbootappllication.Exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PatientNotFound extends RuntimeException {
    private String name;
    private Long id;

    public PatientNotFound(String message, Long id) {
        super(message);
        this.id = id;
    }

    public PatientNotFound(String message, String name) {
        super(message);
        this.name = name;
    }
}
