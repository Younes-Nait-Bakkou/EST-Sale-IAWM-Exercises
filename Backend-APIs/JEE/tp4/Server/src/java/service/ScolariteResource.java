package service;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

// The URL will be: http://localhost:8080/ScolariteREST/webapi/notes
@Path("notes")
public class ScolariteResource {

    Scolarite helper = new Scolarite(); // Your Database Helper

    public ScolariteResource() {}

    // 1. GET ALL NOTES
    // URL: GET /notes
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getJson() {
        return helper.getNotes();
    }

    // 2. ADD A NOTE
    // URL: POST /notes?id=...&matiere=...&note=...
    @POST
    @Produces(MediaType.APPLICATION_JSON) // Returns the confirmation message
    public String putJson(
            @QueryParam("id") int id,
            @QueryParam("matiere") String matiere,
            @QueryParam("note") double note) {
        return helper.addNote(id, matiere, note);
    }

    // 3. DELETE A NOTE
    // URL: PUT /notes/delete/{id}
    // (Using PUT because standard HTML forms sometimes struggle with DELETE, but PUT is fine here)
    @PUT
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteJson(@PathParam("id") int id) {
        return helper.removeNote(id);
    }
}
