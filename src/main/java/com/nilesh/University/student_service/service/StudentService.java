package com.nilesh.University.student_service.service;

import com.nilesh.University.student_service.dto.APIResponseDTO;
import com.nilesh.University.student_service.dto.StudentRequestDTO;
import com.nilesh.University.student_service.dto.StudentResponeDTO;

import java.util.List;

public interface StudentService {
    APIResponseDTO<StudentResponeDTO> createStudents(StudentRequestDTO studentRequestDTO);
    APIResponseDTO<List<StudentResponeDTO>> getAllStudents();
}
