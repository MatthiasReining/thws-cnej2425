package de.thws.students.student.entity;

import java.time.LocalDate;
import java.util.List;

import de.thws.students.logdata.entity.LogData;
import de.thws.students.major.entity.Major;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Student {

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

    // only numbers
    @NotBlank
    public String immatriculationNumber;

    @NotNull
    public LocalDate birthdate;

}
