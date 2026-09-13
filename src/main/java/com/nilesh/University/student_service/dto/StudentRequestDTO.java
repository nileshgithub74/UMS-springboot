package com.nilesh.University.student_service.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class StudentRequestDTO {



    private String firstname;

    private String lastname;

    private String email;

    private LocalDateTime dateOfBirth;

    private String course;

    private String gender;

    private String address;
    private String city;



}
