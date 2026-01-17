package com.est.sale.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep)
            throws ServletException, IOException {

        rep.setContentType("text/html");
        rep.setCharacterEncoding("UTF-8");

        PrintWriter page = rep.getWriter();

        String name = req.getParameter("name");

        page.println("<html><body>");

        if (name != null && !name.isEmpty()) {
            page.println("Hello" + name);
        } else {
            page.println("Name not sent");
            page.println("Please specify a name query param");
        }

        page.println("</body></html>");
    }
}
