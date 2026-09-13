package com.nilesh.University.student_service.service;

import com.nilesh.University.student_service.StudentEnum.DeletedStatus;
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

        List<Student> student = studentRepository.findAllStudentByDeleted(DeletedStatus.NO);


        //entity to response
        List<StudentResponeDTO> allstudent = student.stream().map(StudentMapper::StudentenityToRespone).collect(Collectors.toList());

        APIResponseDTO<List<StudentResponeDTO>> allstudentres = new APIResponseDTO<>("All student fetch successfully", allstudent);
        return allstudentres;


    }

    @Override
    public APIResponseDTO<StudentResponeDTO> findStudentById(Long id) {
        Student student = studentRepository.findByIdAndIsDeleted(id, DeletedStatus.NO).orElseThrow(() -> new RuntimeException("Student not found"));

        //entity to response
        StudentResponeDTO fetchedStudent = StudentMapper.StudentenityToRespone(student);

        APIResponseDTO<StudentResponeDTO> responsedata = new APIResponseDTO<>("Match found", fetchedStudent);
        return responsedata;


    }

    @Override
    public APIResponseDTO<StudentResponeDTO> deleteStudent(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));


        studentRepository.deleteById(id);
        return new
                APIResponseDTO<>("Student deleted Successfully", StudentMapper.StudentenityToRespone(student));


    }

    @Override
    public APIResponseDTO<StudentResponeDTO> softdeleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));


        student.setIsDeleted(DeletedStatus.YES);
        Student savedStudent = studentRepository.save(student);
        return new
                APIResponseDTO<>("Student deleted Successfully", StudentMapper.StudentenityToRespone(savedStudent));

    }

    @Override
    public APIResponseDTO<StudentResponeDTO> updatedStudent(Long id, StudentRequestDTO studentRequestDTO) {
        // check that student exist or not;

        Student existingStudent = studentRepository.findByIdAndIsDeleted(id, DeletedStatus.NO).orElseThrow(() -> new RuntimeException("Student not found"));


        // update response
        Student student = StudentMapper.updateRequest(existingStudent, studentRequestDTO);

        //save to the database;
        Student savedStudent = studentRepository.save(student);

        // entity to response

        StudentResponeDTO studentres = StudentMapper.StudentenityToRespone(savedStudent);

        return new APIResponseDTO<>("Data updated Successfully", studentres);


    }
}
