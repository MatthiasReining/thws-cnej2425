package de.thws.appserver.demo.servlets;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String targetStatus = request.getParameter("targetStatus");

        try {
            response.setStatus(Integer.parseInt(targetStatus));
        } catch (NumberFormatException e) {
            response.getWriter().println("target Status is not an integer -->" + targetStatus);
            response.setStatus(400);
            return;
        }
        response.getWriter().println("Hello hello");

    }

}
