package com.nilesh.University.student_service.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class StudentResponeDTO {
    private Long id;
    private String name;
    private String email;
    private String departement;

    private LocalDateTime created_At;
    private LocalDateTime updated_At;


}
