package com.est.sale.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.est.sale.beans.Etudiant;

public class EtudiantDAO {

    private String url = "jdbc:mysql://localhost:3306/est_scolarite";
    private String user = "younes";
    private String password = "123123zz";

    public List<Etudiant> getStudents() {
        List<Etudiant> students = new ArrayList<Etudiant>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM etudiants");
                ResultSet result = stmt.executeQuery(); ) {

            while (result.next()) {
                Etudiant etu = new Etudiant();
                etu.setNom(result.getString("nom"));
                etu.setNote(result.getDouble("note"));

                students.add(etu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
}
