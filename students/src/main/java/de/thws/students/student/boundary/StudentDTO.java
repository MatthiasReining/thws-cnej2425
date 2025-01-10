package de.thws.students.student.boundary;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentDTO {

    public Long id;

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
