package com.est.sale.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.est.sale.beans.Etudiant;
import com.est.sale.dao.EtudiantDAO;

public class ListControleurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Etudiant> promo = new EtudiantDAO().getStudents();

        req.setAttribute("studentList", promo);

        req.getRequestDispatcher("etudiant-list.jsp").forward(req, resp);
    }
}
