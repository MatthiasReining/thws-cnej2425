package de.thws.students.major.boundary;

import java.util.List;
import java.util.stream.Collectors;

import de.thws.students.major.entity.Major;
import de.thws.students.student.boundary.StudentDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/majors")
public class MajorResource {

    @PersistenceContext
    EntityManager em;

    /**
     * No need for produces annotation, because the default is Quakus
     */
    @GET
    @Path("{id}/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentDTO> getStundentsPerMajor(@PathParam("id") Long id) {

        System.out.println("students size: " + em.find(Major.class, id).students.size());

        return em.find(Major.class, id).students
                .stream()
                .map(student -> {
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.id = student.id;
                    studentDTO.firstname = student.firstname;
                    studentDTO.lastname = student.lastname;
                    studentDTO.immatriculationNumber = student.immatriculationNumber;
                    studentDTO.birthdate = student.birthdate;
                    return studentDTO;
                })
                .collect(Collectors.toList());
    }

}
