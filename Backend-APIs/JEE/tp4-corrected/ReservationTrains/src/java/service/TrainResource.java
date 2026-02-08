package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import entities.Train;

@Path("trains")
public class TrainResource {

    private static List<Train> trains = new ArrayList<>();

    static {
        trains.add(new Train("TR100", "Rabat", "Casablanca", 1000));
        trains.add(new Train("TR200", "Casablanca", "Marrakech", 1400));
        trains.add(new Train("TR300", "Tanger", "Rabat", 800));
        trains.add(new Train("TR400", "Fes", "Oujda", 1600));
    }

    public TrainResource() {}

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Train> getTrains() {
        return trains;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Train getTrain(@PathParam("id") String id) {
        for (Train t : trains) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null; // Train not found
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_XML)
    public List<Train> searchTrains(
            @QueryParam("depart") String depart, @QueryParam("arrivee") String arrivee) {
        List<Train> results = new ArrayList<>();

        for (Train t : trains) {
            boolean matchDepart = (depart == null || t.getVilleDepart().equalsIgnoreCase(depart));
            boolean matchArrivee =
                    (arrivee == null || t.getVilleArrivee().equalsIgnoreCase(arrivee));

            if (matchDepart && matchArrivee) {
                results.add(t);
            }
        }
        return results;
    }
}
