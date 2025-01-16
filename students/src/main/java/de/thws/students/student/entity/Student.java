package de.thws.students.student.entity;

import java.time.LocalDate;
import java.util.List;

import de.thws.students.logdata.entity.LogData;
import de.thws.students.major.entity.Major;
import de.thws.students.student.boundary.StudentDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@NamedQueries({
        @NamedQuery(name = Student.FIND_ALL, query = "SELECT s FROM Student s"),
        @NamedQuery(name = Student.FIND_BY_IMMATRICULATION_NUMBER, query = "SELECT s FROM Student s WHERE s.immatriculationNumber = :"
                + Student.PARAM_IMMATRICULATION_NUMBER)
})
public class Student {

    public static final String FIND_ALL = "Student.findAll";
    public static final String FIND_BY_IMMATRICULATION_NUMBER = "Student.findByImmatriculationNumber";

    public static final String PARAM_IMMATRICULATION_NUMBER = "immatriculationNumber";

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne
    public Major major;

    @OneToMany(cascade = CascadeType.ALL)
    public List<LogData> logData;

    @NotBlank
    public String firstname;
    @NotBlank
    public String lastname;

    public String email;

    public String degree;

    public String status;

    public String position;

    // only numbers
    @NotBlank
    public String immatriculationNumber;

    @NotNull
    public LocalDate birthdate;

    public StudentDTO toDTO() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.id = this.id;
        studentDTO.firstname = this.firstname;
        studentDTO.lastname = this.lastname;
        studentDTO.immatriculationNumber = this.immatriculationNumber;
        studentDTO.birthdate = this.birthdate;
        studentDTO.email = this.email;
        studentDTO.degree = this.degree;
        studentDTO.status = this.status;
        studentDTO.majorName = this.major.name;
        studentDTO.position = this.position;

        return studentDTO;

    }

}
