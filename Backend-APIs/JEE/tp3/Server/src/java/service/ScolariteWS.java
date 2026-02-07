package service;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "ScolariteWS")
public class ScolariteWS {

    Scolarite scolarite = new Scolarite();

    @WebMethod(operationName = "addNote")
    public String addNote(
            @WebParam(name = "id") int id,
            @WebParam(name = "matiere") String matiere,
            @WebParam(name = "note") double note) {
        return scolarite.addNote(id, matiere, note);
    }

    @WebMethod(operationName = "removeNote")
    public String removeNote(@WebParam(name = "id") int id) {
        return scolarite.removeNote(id);
    }

    @WebMethod(operationName = "getNotes")
    public List<String> getNotes() {
        return scolarite.getNotes();
    }
}
