package com.est.sale.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.est.sale.beans.Etudiant;

public class ListControleurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Etudiant> promo = new ArrayList<Etudiant>();

        Etudiant etu1 = new Etudiant();
        etu1.setNom("Ahmed");
        etu1.setNote(15.31);

        Etudiant etu2 = new Etudiant();
        etu2.setNom("Sofia");
        etu2.setNote(10);

        Etudiant etu3 = new Etudiant();
        etu3.setNom("Karim");
        etu3.setNote(9);

        promo.add(etu1);
        promo.add(etu2);
        promo.add(etu3);

        req.setAttribute("studentList", promo);

        req.getRequestDispatcher("etudiant-list.jsp").forward(req, resp);
    }
}
