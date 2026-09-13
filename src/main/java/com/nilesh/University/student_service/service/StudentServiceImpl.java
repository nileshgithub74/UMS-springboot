package com.nilesh.University.student_service.service;

import com.nilesh.University.student_service.dto.StudentRequestDTO;
import com.nilesh.University.student_service.dto.StudentResponeDTO;
import com.nilesh.University.student_service.entity.Student;
import com.nilesh.University.student_service.mapper.StudentMapper;
import com.nilesh.University.student_service.repository.StudentRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentResponeDTO createStudents(StudentRequestDTO studentRequestDTO) {
        //Request to Entity mapper

        Student student = StudentMapper.StudentRequestToEntity(studentRequestDTO);
        Student createdStudent = studentRepository.save(student);


        // enity to respone dto

        StudentResponeDTO response = StudentMapper.StudentenityToRespone(createdStudent);
        return response;


    }
}
