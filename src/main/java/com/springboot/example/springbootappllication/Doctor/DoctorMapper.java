package com.springboot.example.springbootappllication.Doctor;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor mapToEntity(DoctorDto doctorDto);

    Doctor updateEntity(DoctorDto doctorDto, @MappingTarget Doctor doctor);
}
