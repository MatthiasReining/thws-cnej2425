package de.thws.courses.boundary;

import de.thws.courses.control.CourseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("courses")
public class CoursesResources {

    @Inject
    CourseService courseService;

    @GET
    public CourseDTO coursesByStudent(@QueryParam("studentId") long id,
            @QueryParam("clientType") @DefaultValue("restclient") String clientType) {

        if ("httpclient".equals(clientType)) {
            return courseService.getCoursesByStudentViaHttpClient(id);
        }

        return courseService.getCouresesByStudentViaRestClient(id);

    }
}
