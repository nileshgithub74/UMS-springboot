package com.nilesh.University.student_service.controller;


import com.nilesh.University.student_service.dto.APIResponseDTO;
import com.nilesh.University.student_service.dto.StudentRequestDTO;
import com.nilesh.University.student_service.dto.StudentResponeDTO;
import com.nilesh.University.student_service.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //get Mapping
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to the Student Dashbord");
    }

    // create students

    @PostMapping
    public ResponseEntity<APIResponseDTO<StudentResponeDTO>> createStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        APIResponseDTO<StudentResponeDTO> createdStudent = studentService.createStudents(studentRequestDTO);


        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);

    }

    // get All students;

    @GetMapping
    public ResponseEntity<APIResponseDTO<List<StudentResponeDTO>>> getAllStudent() {
        APIResponseDTO<List<StudentResponeDTO>> allstudents = studentService.getAllStudents();

        return ResponseEntity.status(HttpStatus.OK).body(allstudents);
    }


    // getStudentById;


    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDTO<StudentResponeDTO>> getStudentById(@PathVariable("id") Long id) {
        APIResponseDTO<StudentResponeDTO> studentResponse = studentService.findStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponseDTO<StudentResponeDTO>> updatedStudent(@PathVariable("id") Long id, @RequestBody StudentRequestDTO studentRequestDTO) {
        APIResponseDTO<StudentResponeDTO> studentResponse = studentService.updatedStudent(id, studentRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponseDTO<StudentResponeDTO>> deleteStudent(@PathVariable("id") Long id) {
        APIResponseDTO<StudentResponeDTO> studentResponse = studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<APIResponseDTO<StudentResponeDTO>> softdeleteStudent(@PathVariable("id") Long id) {
        APIResponseDTO<StudentResponeDTO> studentResponse = studentService.softdeleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }





}
