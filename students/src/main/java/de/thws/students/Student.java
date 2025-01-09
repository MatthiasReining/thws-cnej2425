package de.thws.students;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Student {

    @Id
    @GeneratedValue
    public Long id;

    public String magic;

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
