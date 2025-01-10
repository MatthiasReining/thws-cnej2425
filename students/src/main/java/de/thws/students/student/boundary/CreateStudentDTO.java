package de.thws.students.student.boundary;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateStudentDTO {

    @NotBlank
    public String firstname;
    @NotBlank
    public String lastname;

    @Email
    public String email;

    @NotNull
    public LocalDate birthdate;
}
