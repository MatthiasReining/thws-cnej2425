package de.thws.students;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/students")
public class StudentResource {

    @PersistenceContext
    EntityManager em;

    /**
     * No need for produces annotation, because the default is Quakus
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentDTO getStundent(@PathParam("id") Long id) {

        Student student = em.find(Student.class, id);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.id = student.id;
        studentDTO.firstname = student.firstname;
        studentDTO.lastname = student.lastname;
        studentDTO.immatriculationNumber = student.immatriculationNumber;
        studentDTO.birthdate = student.birthdate;

        return studentDTO;
    }

    @POST
    @Transactional
    public Student createStudent(@Valid StudentDTO studentDTO) {
        System.out.println("Student: " + studentDTO);

        Student student = new Student();
        student.birthdate = studentDTO.birthdate;
        student.firstname = studentDTO.firstname;
        student.immatriculationNumber = studentDTO.immatriculationNumber;
        student.lastname = studentDTO.lastname;

        student = em.merge(student);

        System.out.println("Student ID: " + student.id);

        return student;
    }

    /**
     * Create student in a special way
     * 
     * @param student
     * @return Student
     */
    @POST
    @Path("special-201")
    @APIResponse(responseCode = "201", description = "create student in a special way", content = {
            @Content(mediaType = "application/text", schema = @Schema(implementation = StudentDTO.class)) })
    public Response createStudentSpecial201(@Valid StudentDTO student) {
        System.out.println("Student: " + student);
        return Response.status(Response.Status.CREATED).entity(student).build();

    }

}
