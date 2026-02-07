package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Scolarite {

    private static Connection cnx;
    private static String connectionError = ""; // Store the error message

    // 1. Connect to Database
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/tp3_jee?useSSL=false&allowPublicKeyRetrieval=true",
                            "younes",
                            "123123zz");
        } catch (Exception e) {
            e.printStackTrace();
            connectionError = "DB Connection Failed: " + e.toString(); // Save the error!
        }
    }

    // Helper: Check connection before doing work
    private String checkConnection() {
        if (cnx == null) {
            return "Critical Error: " + connectionError;
        }
        return null; // No error
    }

    // 2. Add a Note
    public String addNote(int id, String matiere, double note) {
        String error = checkConnection();
        if (error != null) return error; // Return the REAL error to SoapUI

        try {
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO notes VALUES (?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, matiere);
            ps.setDouble(3, note);
            ps.executeUpdate();
            return "Note added successfully!";
        } catch (Exception e) {
            return "SQL Error: " + e.getMessage();
        }
    }

    // 3. Remove a Note
    public String removeNote(int id) {
        String error = checkConnection();
        if (error != null) return error;

        try {
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM notes WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Note removed successfully!";
        } catch (Exception e) {
            return "SQL Error: " + e.getMessage();
        }
    }

    // 4. Get all Notes
    public List<String> getNotes() {
        List<String> list = new ArrayList<>();
        String error = checkConnection();
        if (error != null) {
            list.add(error);
            return list;
        }

        try {
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM notes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(
                        "ID: "
                                + rs.getInt(1)
                                + " | Subject: "
                                + rs.getString(2)
                                + " | Grade: "
                                + rs.getDouble(3));
            }
        } catch (Exception e) {
            list.add("Error: " + e.getMessage());
        }
        return list;
    }
}
