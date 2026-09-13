package com.nilesh.University.student_service.controller;


import com.nilesh.University.student_service.dto.StudentRequestDTO;
import com.nilesh.University.student_service.dto.StudentResponeDTO;
import com.nilesh.University.student_service.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    public  ResponseEntity<StudentResponeDTO> createStudent( @RequestBody StudentRequestDTO studentRequestDTO){
     StudentResponeDTO createdStudent =    studentService.createStudents(studentRequestDTO);

     return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);

    }


}
