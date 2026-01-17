package com.est.sale.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.est.sale.beans.Etudiant;

public class ControleurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Etudiant etu = new Etudiant();
        etu.setNom("Ahmed");
        etu.setNote(15.31);

        req.setAttribute("studentModel", etu);

        req.getRequestDispatcher("etudiant.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String postName = req.getParameter("nom");
        String postNote = req.getParameter("note");

        String name = postName;
        double note = Double.parseDouble(postNote);

        Etudiant etu = new Etudiant();
        etu.setNote(note);
        etu.setNom(name);

        req.setAttribute("studentModel", etu);

        req.getRequestDispatcher("etudiant.jsp").forward(req, resp);
    }
}
