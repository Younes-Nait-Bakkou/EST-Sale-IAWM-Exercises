
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addNote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addNote"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="matiere" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNote", propOrder = {
    "id",
    "matiere",
    "note"
})
public class AddNote {

    protected int id;
    protected String matiere;
    protected double note;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the matiere property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatiere() {
        return matiere;
    }

    /**
     * Sets the value of the matiere property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatiere(String value) {
        this.matiere = value;
    }

    /**
     * Gets the value of the note property.
     * 
     */
    public double getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     */
    public void setNote(double value) {
        this.note = value;
    }

}
