package com.nilesh.University.student_service.mapper;

import com.nilesh.University.student_service.dto.StudentRequestDTO;
import com.nilesh.University.student_service.dto.StudentResponeDTO;
import com.nilesh.University.student_service.entity.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudentMapper {

    public static Student StudentRequestToEntity(StudentRequestDTO studentRequestDTO) {

        Student student = new Student();

        student.setFirstname(studentRequestDTO.getFirstname());
        student.setLastname(studentRequestDTO.getLastname());
        student.setEmail(studentRequestDTO.getEmail());
        student.setDateOfBirth(studentRequestDTO.getDateOfBirth());
        student.setCourse(studentRequestDTO.getCourse());
        student.setGender(studentRequestDTO.getGender());
        student.setAddress(studentRequestDTO.getAddress());
        student.setCity(studentRequestDTO.getCity());

        // set the rest field her

        student.setAddmissionDate(LocalDate.now());
        student.setStatus("Active");
        student.setDepartment("B.tech");
        student.setCreated_At(LocalDateTime.now());
        student.setUpdated_At(LocalDateTime.now());


        return student;

    }

    public static StudentResponeDTO StudentenityToRespone(Student student) {

        StudentResponeDTO responeDTO = new StudentResponeDTO();

        responeDTO.setEmail(student.getEmail());
        responeDTO.setFirstname(student.getFirstname());
        responeDTO.setId(student.getId());
        responeDTO.setLastname(student.getLastname());
        responeDTO.setDepartement(student.getDepartment());

        return responeDTO;


    }

}
