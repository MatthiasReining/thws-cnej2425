package de.thws.appserver.demo.servlets;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class BrowserBlockerFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        String userAgent = req.getHeader("user-agent");

        if (userAgent.contains("Chrome")) {
            // no chrome rendering engine
            return;
        }

        // String browser = req.getHeader("Sec-Ch-Ua");
        // if (browser != null && browser.toLowerCase().contains("edge")) {
        // resp.getWriter().println("We don't like Edge!");
        // return;
        // }

        super.doFilter(req, res, chain);

    }

}
