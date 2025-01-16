package de.thws.students.cdi;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/example-servlet")
public class ExampleServlet extends HttpServlet {

    @Inject
    BusinessLogic1 businessLogic1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Session Example --> change BusinessLogic1 SessionScoped

        var session = req.getSession(true);
        session.setAttribute("key", "value 1");

        System.out.println("session attributes:");
        session.getAttributeNames().asIterator().forEachRemaining(n -> System.out.println(session.getAttribute(n)));

        businessLogic1.execute();

        resp.getWriter().write("Hello World from Servlet!");
    }

}
