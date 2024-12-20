package de.thws.appserver.demo.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.validation.Valid;

@WebService
public class StudentService {

    @WebMethod(operationName = "AnlageStudent")
    public StudentDTO createStudent(@Valid StudentDTO student) {
        System.out.println("Student: " + student);
        student.immatriculationNumber = "" + System.currentTimeMillis();

        return student;

    }

}
