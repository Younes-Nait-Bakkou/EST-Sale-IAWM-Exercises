package client;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("🔌 Connecting to Server...");

            // 1. Create the Service Connection
            ScolariteWS_Service service = new ScolariteWS_Service();
            ScolariteWS port = service.getScolariteWSPort();

            // 2. Test: Add a Note
            System.out.println("📝 Adding a new note...");
            // Adding Student ID 2024, Subject "Java Client", Grade 19.5
            String response = port.addNote(2024, "Java Client", 19.5);
            System.out.println("Server Response: " + response);

            // 3. Test: Get All Notes
            System.out.println("\n📚 Fetching all notes...");
            List<String> notes = port.getNotes();

            // Print the list nicely
            for (String n : notes) {
                System.out.println(n);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
