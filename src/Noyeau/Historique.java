package Noyeau;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Historique implements Serializable {

    private Facture facture;
    private Date date;
    private String nom;
    private Double total;
    public static int i;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Historique(Facture facture, Date date, Double prix) {
        try
        {
            FileInputStream fis = new FileInputStream("Fich");
            ObjectInputStream ois = new ObjectInputStream(fis);
            i =  ois.readInt();
            ois.close();
            fis.close();
        }
        catch (IOException ignored)
        {

        }
        finally {
            this.facture = facture;
            this.date = date;
            this.nom = "Facture N"+i;
            i++;
            this.total = prix;
            System.out.println(total);
        }

    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
