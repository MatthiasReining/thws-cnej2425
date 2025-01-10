package de.thws.students;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    // alternative to mappedby: @JoinColumn(name = "student_id")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
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
