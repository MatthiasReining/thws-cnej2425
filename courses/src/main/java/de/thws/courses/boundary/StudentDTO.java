package de.thws.courses.boundary;

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

    public String email;
    public String degree;
    public String status;

    public String majorName;
    public String position;

}
