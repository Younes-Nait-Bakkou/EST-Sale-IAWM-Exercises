package entities;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookTrain {

    private String numReservation;
    private String numTrain; // The ID of the train (e.g., TR100)
    private int numberPlaces;

    public BookTrain() {}

    public BookTrain(String numReservation, String numTrain, int numberPlaces) {
        this.numReservation = numReservation;
        this.numTrain = numTrain;
        this.numberPlaces = numberPlaces;
    }

    // Getters and Setters
    public String getNumReservation() {
        return numReservation;
    }

    public void setNumReservation(String numReservation) {
        this.numReservation = numReservation;
    }

    public String getNumTrain() {
        return numTrain;
    }

    public void setNumTrain(String numTrain) {
        this.numTrain = numTrain;
    }

    public int getNumberPlaces() {
        return numberPlaces;
    }

    public void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }
}
