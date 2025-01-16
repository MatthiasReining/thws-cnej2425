package de.thws.students.student.boundary;

import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import de.thws.students.performance.boundary.PerformanceMeassurement;
import de.thws.students.student.control.StudentService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/students")
@PerformanceMeassurement
public class StudentResource {

    @Inject
    StudentService studentService;

    @ConfigProperty(name = "thws.magic")
    Boolean magic;

    @GET
    public List<StudentDTO> getStudents(@QueryParam("immatriculationNumber") String immatriculationNumber) {

        if (magic == true) {
            System.out.println("run with magic");
        }

        if (immatriculationNumber != null)
            return studentService.getStudentsByImmatriculationNumber(immatriculationNumber);

        return studentService.getAllStudents();
    }

    @GET
    @Path("{id}")

    public StudentDTO getStundent(@PathParam("id") Long id,
            @QueryParam("audit") @DefaultValue("true") boolean audit) {

        if (audit)
            return studentService.getStudentAndWriteAuditLog(id);

        return studentService.getStundent(id);
    }

    @POST
    public StudentDTO createStudent(@Valid CreateStudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @POST
    @Path("tx-example")
    public StudentDTO createStudentWithTxExample(@Valid StudentDTO studentDTO) {
        return studentService.createStudentTxExample(studentDTO);
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
