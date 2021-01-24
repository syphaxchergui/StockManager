package Noyeau;

import java.io.Serializable;
import java.util.ArrayList;

public class Facture implements Serializable {
    private ArrayList<ProduitAchat> produits;
    private Double prixFinal;


    public Facture(ArrayList<ProduitAchat> produits) {
        this.produits = produits;
    }


    public ArrayList<ProduitAchat> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<ProduitAchat> produits) {
        this.produits = produits;
    }

    public Double getPrixFinal() {
        return prixFinal;
    }

    public void setPrixFinal(double prixFinal) {
        this.prixFinal = prixFinal;
    }
}
