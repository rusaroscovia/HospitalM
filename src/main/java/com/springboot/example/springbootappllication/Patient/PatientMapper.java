package com.springboot.example.springbootappllication.Patient;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient mapToEntity(PatientDto patientDto);

    Patient updateEntity(PatientDto patientDto, @MappingTarget Patient patient);
}
