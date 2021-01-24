package Noyeau;

import java.io.Serializable;

public class ProduitStock implements Serializable {
    private String id;
    private String name;
    private double prix;
    private double prixAchat;
    private double quantite;
    private String unite;
    private String categorie;


    public ProduitStock(String id, String name, double prix,double prixAchat, double quantite, String unite, String categorie) {
        this.id = id;
        this.name = name;
        this.prix = prix;
        this.quantite = quantite;
        this.unite = unite;
        this.prixAchat = prixAchat;
        this.categorie = categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public boolean isAvailable(){
        return (quantite != 0) ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }
}
