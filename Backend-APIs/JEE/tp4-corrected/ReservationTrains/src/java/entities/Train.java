package entities;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Train {

    private String id;
    private String villeDepart;
    private String villeArrivee;
    private int heureDepart; // e.g., 1400 for 14:00

    public Train() {}

    public Train(String id, String villeDepart, String villeArrivee, int heureDepart) {
        this.id = id;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.heureDepart = heureDepart;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public int getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(int heureDepart) {
        this.heureDepart = heureDepart;
    }
}
