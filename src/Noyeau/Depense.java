package Noyeau;

import java.io.Serializable;
import java.util.Date;

public class Depense implements Serializable {
    private Date date;
    private Double somme;
    private String nature;
    private String details;

    public Depense(Date date, Double somme, String nature, String details) {
        this.date = date;
        this.somme = somme;
        this.nature = nature;
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSomme() {
        return somme;
    }

    public void setSomme(Double somme) {
        this.somme = somme;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
