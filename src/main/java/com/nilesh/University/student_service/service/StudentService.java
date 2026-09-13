package com.nilesh.University.student_service.service;

import com.nilesh.University.student_service.dto.StudentRequestDTO;
import com.nilesh.University.student_service.dto.StudentResponeDTO;

public interface StudentService {
    StudentResponeDTO createStudents(StudentRequestDTO studentRequestDTO);
}
