package com.nilesh.University.student_service.controller;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class StudentController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstname;

    @Column(nullable = false, length = 50)
    private String lastname;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    private LocalDateTime dateOfBirth;

    @Column(nullable = false)
    private String course;

    private String gender;
    private String address;
    private String city;

    @Column(nullable = false)
    private LocalDate addmissionDate;

    @Column(nullable = false)
    private String status;

    private LocalDateTime created_At;
    private LocalDateTime updated_At;


}
