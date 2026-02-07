package clientrest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientREST {

    // The Base URL of your API
    private static final String API_URL = "http://localhost:8080/ScolariteREST/webapi/notes";

    public static void main(String[] args) {
        try {
            System.out.println("--- 🚀 STARTING REST CLIENT ---");

            // 1. TEST POST: Add a new student
            System.out.println("\n[1] Adding a new student (ID: 4000)...");
            sendPost(4000, "Java_REST_Client", 17.5);

            // 2. TEST GET: Read all students
            System.out.println("\n[2] Reading all students...");
            sendGet();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // METHOD TO SEND GET REQUEST
    private static void sendGet() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        System.out.println("Server Output:");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();
    }

    // METHOD TO SEND POST REQUEST
    private static void sendPost(int id, String matiere, double note) throws Exception {
        // Construct the URL with parameters (just like the curl command)
        String urlParameters = "?id=" + id + "&matiere=" + matiere + "&note=" + note;
        URL url = new URL(API_URL + urlParameters);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true); // Necessary for POST

        // Send the request
        OutputStream os = conn.getOutputStream();
        os.write(new byte[0]); // We send empty body because params are in the URL
        os.flush();

        if (conn.getResponseCode() != 200 && conn.getResponseCode() != 204) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        System.out.println("Server Response:");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();
    }
}
