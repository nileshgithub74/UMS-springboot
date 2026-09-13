package com.nilesh.University.student_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstname;

    @Column(nullable = false, length = 50)
    private String lastname;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String gender;

    private String address;
    private String city;

    @Column(nullable = false)
    private LocalDate addmissionDate;

    @Column(nullable = false)
    private String status;


    @Column(nullable = false)
    private String department;

    private LocalDateTime created_At;
    private LocalDateTime updated_At;

}
