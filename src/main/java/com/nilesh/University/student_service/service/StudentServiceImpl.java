package com.nilesh.University.student_service.service;

import com.nilesh.University.student_service.dto.APIResponseDTO;
import com.nilesh.University.student_service.dto.StudentRequestDTO;
import com.nilesh.University.student_service.dto.StudentResponeDTO;
import com.nilesh.University.student_service.entity.Student;
import com.nilesh.University.student_service.mapper.StudentMapper;
import com.nilesh.University.student_service.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public APIResponseDTO<StudentResponeDTO> createStudents(StudentRequestDTO studentRequestDTO) {
        //Request to Entity mapper

        Student student = StudentMapper.StudentRequestToEntity(studentRequestDTO);
        Student savedStudent = studentRepository.save(student);


        // enity to respone dto
        StudentResponeDTO studentResponeDTO = StudentMapper.StudentenityToRespone(savedStudent);


        APIResponseDTO<StudentResponeDTO> response = new APIResponseDTO<>("Student Created Successfully", studentResponeDTO);
        return response;


    }

    @Override
    public APIResponseDTO<List<StudentResponeDTO>> getAllStudents() {

        List<Student> student = studentRepository.findAll();


        //entity to response
        List<StudentResponeDTO>  allstudent = student.stream().map(StudentMapper::StudentenityToRespone).collect(Collectors.toList());

        APIResponseDTO<List<StudentResponeDTO>> allstudentres = new APIResponseDTO<>("All student fetch successfully", allstudent);
        return allstudentres;


    }
}
