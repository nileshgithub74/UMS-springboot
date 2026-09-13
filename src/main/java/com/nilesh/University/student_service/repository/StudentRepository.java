package com.nilesh.University.student_service.repository;

import com.nilesh.University.student_service.StudentEnum.DeletedStatus;
import com.nilesh.University.student_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("""
                   select s
                   from Student s
                   where s.isDeleted = :status
                   order by s.id asc
            """)
    List<Student> findAllStudentByDeleted(DeletedStatus status);


    Optional<Student> findByIdAndIsDeleted(Long id, DeletedStatus status);
}
