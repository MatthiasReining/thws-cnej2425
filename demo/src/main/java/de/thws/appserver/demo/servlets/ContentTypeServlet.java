package de.thws.appserver.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contenttype")
public class ContentTypeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // with pdf the browser will show an error
        // response.setContentType("application/pdf");
        response.setContentType("text/plain");
        response.getWriter().println("Hello World");

    }

}
