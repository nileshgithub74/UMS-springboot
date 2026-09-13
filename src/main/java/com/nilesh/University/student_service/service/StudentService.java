package com.nilesh.University.student_service.service;

import com.nilesh.University.student_service.dto.APIResponseDTO;
import com.nilesh.University.student_service.dto.StudentRequestDTO;
import com.nilesh.University.student_service.dto.StudentResponeDTO;

import java.util.List;

public interface StudentService {
    APIResponseDTO<StudentResponeDTO> createStudents(StudentRequestDTO studentRequestDTO);
    APIResponseDTO<List<StudentResponeDTO>> getAllStudents();
    APIResponseDTO<StudentResponeDTO> findStudentById(Long id);
    APIResponseDTO<StudentResponeDTO> deleteStudent(Long id);
    APIResponseDTO<StudentResponeDTO> softdeleteStudent(Long id);
    APIResponseDTO<StudentResponeDTO> updatedStudent(Long id, StudentRequestDTO studentRequestDTO);


}
