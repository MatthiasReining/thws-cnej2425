package de.thws.courses.boundary;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("courses")
public class CoursesResources {

    @GET
    public String coursesByStudent(@QueryParam("studentId") long id) {

        try {
            var request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/students/" + id))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            var content = response.body();
            System.out.println(content);

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "All courses from student " + id;
    }
}
