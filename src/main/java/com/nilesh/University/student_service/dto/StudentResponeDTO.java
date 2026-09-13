package com.nilesh.University.student_service.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentResponeDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String departement;

}
