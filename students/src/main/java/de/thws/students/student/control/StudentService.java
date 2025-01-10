package de.thws.students.student.control;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import de.thws.students.logdata.entity.LogData;
import de.thws.students.major.entity.Major;
import de.thws.students.student.boundary.CreateStudentDTO;
import de.thws.students.student.boundary.StudentDTO;
import de.thws.students.student.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentService {

    @PersistenceContext
    EntityManager em;

    @Inject
    MagicService magicService;

    @Transactional
    public StudentDTO createStudent(CreateStudentDTO createStudentDTO) {
        Student student = new Student();
        student.birthdate = createStudentDTO.birthdate;
        student.firstname = createStudentDTO.firstname;
        student.email = createStudentDTO.email;
        student.immatriculationNumber = RandomStringUtils.secure().next(8);
        student.degree = "Bsc";
        student.status = "active";
        student.lastname = createStudentDTO.lastname;

        Major major = em.find(Major.class, 1L);
        student.major = major;

        System.out.println("Student ID: " + student.id);

        student.logData = new ArrayList<>();
        student.logData.add(new LogData("Student created"));

        student = em.merge(student);

        var d1 = student.major;
        var d2 = student.logData.size();

        return student.toDTO();
    }

    public StudentDTO getStundent(Long id) {

        return em.find(Student.class, id).toDTO();
    }

    @Transactional
    public StudentDTO getStudentAndWriteAuditLog(Long id) {

        Student student = em.find(Student.class, id);

        student.logData.add(new LogData("Student data accessed"));

        return student.toDTO();
    }

    public List<StudentDTO> getAllStudents() {
        return em.createNamedQuery(Student.FIND_ALL, Student.class)
                .getResultStream()
                .map(Student::toDTO)
                .toList();
    }

    public List<StudentDTO> getStudentsByImmatriculationNumber(String immatriculationNumber) {
        return em.createNamedQuery(Student.FIND_BY_IMMATRICULATION_NUMBER, Student.class)
                .setParameter(Student.PARAM_IMMATRICULATION_NUMBER, immatriculationNumber)
                .getResultStream()
                .map(Student::toDTO)
                .toList();
    }

    @Transactional
    public StudentDTO createStudentTxExample(StudentDTO studentDTO) {
        Student student = new Student();
        student.birthdate = studentDTO.birthdate;
        student.firstname = studentDTO.firstname;
        student.immatriculationNumber = studentDTO.immatriculationNumber;
        student.lastname = studentDTO.lastname;

        Major major = em.find(Major.class, 1L);
        student.major = major;

        student.logData = new ArrayList<>();
        student.logData.add(new LogData("Student created"));

        student = em.merge(student);

        magicService.magicIsWonderful();
        magicService.failedMagic();

        return student.toDTO();
    }

}
