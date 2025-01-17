package de.thws.courses.control;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import de.thws.courses.boundary.StudentDTO;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/students")
@RegisterRestClient(configKey = "students-api")
public interface StudentResource {

    @GET
    @Path("{id}")
    public StudentDTO getStundent(@PathParam("id") Long id,
            @QueryParam("audit") @DefaultValue("true") boolean audit);

}
