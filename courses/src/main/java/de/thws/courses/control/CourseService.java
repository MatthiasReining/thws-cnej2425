package de.thws.courses.control;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import de.thws.courses.boundary.CourseDTO;
import de.thws.courses.boundary.StudentDTO;
import de.thws.courses.entity.Course;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CourseService {

    @RestClient
    StudentResource studentResource;

    public CourseDTO getCouresesByStudentViaRestClient(long id) {
        // TODO implement me

        System.out.println("Calling studentResource.getStundent(" + id + ", true)");
        StudentDTO student = studentResource.getStundent(id, true);

        System.out.println("Student: " + student.firstname);
        CourseDTO course = getCourse(student);

        return course;
    }

    public CourseDTO getCoursesByStudentViaHttpClient(long id) {

        try {
            var request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/students/" + id))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            var content = response.body();
            System.out.println(content);
            // TODO mapping in DTO without Jackson exceptions
            // ObjectMapper mapper = new ObjectMapper();
            // StudentDTO student = mapper.readValue(content, StudentDTO.class);
            // System.out.println(student.firstname);

            StudentDTO student = new StudentDTO();
            student.firstname = "Max";
            student.id = id;
            CourseDTO course = getCourse(student);

            return course;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private CourseDTO getCourse(StudentDTO student) {

        Course c = Course.findById(1L);
        CourseDTO course = new CourseDTO();
        course.name = c.name;
        course.description = c.description;
        course.students = List.of(student);
        return course;
    }

}
