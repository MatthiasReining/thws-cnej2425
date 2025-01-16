package de.thws.students.cdi;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@RequestScoped
@Path("/example")
public class ExampleResource {

    @Inject
    BusinessLogic1 businessLogic1;

    @GET
    public String example() {

        System.out.println("------------- ExampleResource.example() -------------");

        businessLogic1.execute();

        return "Hello World!";
    }
}
