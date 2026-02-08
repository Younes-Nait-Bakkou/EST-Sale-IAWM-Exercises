package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import entities.BookTrain;

@Path("bookings")
public class BookTrainResource {

    // Simulating a database of reservations
    private static List<BookTrain> bookings = new ArrayList<>();

    public BookTrainResource() {}

    /** 1. List all reservations URL: GET http://localhost:8080/ReservationTrains/webapi/bookings */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<BookTrain> getBookings() {
        return bookings;
    }

    /**
     * 2. Create a new reservation URL: POST http://localhost:8080/ReservationTrains/webapi/bookings
     * Body: XML of the reservation
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void createBooking(BookTrain booking) {
        bookings.add(booking);
        System.out.println("New booking added: " + booking.getNumReservation());
    }
}
