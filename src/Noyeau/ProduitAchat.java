package Noyeau;

import java.io.Serializable;

public class ProduitAchat implements Serializable {
    private ProduitStock produitStock;
    private String nomProduit;
    private Double nbr;
    private Double prix;

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }



    public ProduitAchat(ProduitStock produitStock, Double nbr) {
        this.produitStock = produitStock;
        this.nomProduit = produitStock.getName();
        this.nbr = nbr;
        this.prix = produitStock.getPrix();
    }

    public ProduitStock getProduitStock() {
        return produitStock;
    }

    public void setProduitStock(ProduitStock produitStock) {
        this.produitStock = produitStock;
    }

    public Double getNbr() {
        return nbr;
    }
    public Double getPrix() {
        return prix;
    }

    public void setNbr(Double nombre) {
        this.nbr = nombre;
    }
}
