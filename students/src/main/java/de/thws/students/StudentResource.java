package de.thws.students;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

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

    /**
     * No need for produces annotation, because the default is Quakus
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentDTO getStundent(@PathParam("id") String id) {
        StudentDTO student = new StudentDTO();
        student.firstname = "Mickey";
        student.lastname = "Mouse";
        student.immatriculationNumber = "123456";
        student.birthdate = java.time.LocalDate.of(2000, 11, 18);

        return student;
    }

    @POST
    public void createStudent(@Valid StudentDTO student) {
        System.out.println("Student: " + student);

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
