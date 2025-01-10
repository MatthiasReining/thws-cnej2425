package de.thws.students.student.control;

import java.util.ArrayList;

import de.thws.students.logdata.entity.LogData;
import de.thws.students.major.entity.Major;
import de.thws.students.student.boundary.StudentDTO;
import de.thws.students.student.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentService {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public Student createStudent(StudentDTO studentDTO) {
        System.out.println("Student: " + studentDTO);

        Student student = new Student();
        student.birthdate = studentDTO.birthdate;
        student.firstname = studentDTO.firstname;
        student.immatriculationNumber = studentDTO.immatriculationNumber;
        student.lastname = studentDTO.lastname;

        Major major = em.find(Major.class, 1L);
        student.major = major;

        System.out.println("Student ID: " + student.id);

        student.logData = new ArrayList<>();
        student.logData.add(new LogData("Student created"));

        student = em.merge(student);

        var d1 = student.major;
        var d2 = student.logData.size();

        return student;
    }

    public StudentDTO getStundent(Long id) {

        Student student = em.find(Student.class, id);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.id = student.id;
        studentDTO.firstname = student.firstname;
        studentDTO.lastname = student.lastname;
        studentDTO.immatriculationNumber = student.immatriculationNumber;
        studentDTO.birthdate = student.birthdate;

        return studentDTO;
    }

    @Transactional
    public StudentDTO getStudentAndWriteAuditLog(Long id) {

        Student student = em.find(Student.class, id);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.id = student.id;
        studentDTO.firstname = student.firstname;
        studentDTO.lastname = student.lastname;
        studentDTO.immatriculationNumber = student.immatriculationNumber;
        studentDTO.birthdate = student.birthdate;

        student.logData.add(new LogData("Student data accessed"));

        return studentDTO;
    }

}
