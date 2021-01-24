package sample;

import Noyeau.ProduitAchat;
import Noyeau.ProduitStock;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailsFacture implements Initializable {


    public TableView<ProduitAchat> tableDetails;
    public TableColumn<ProduitAchat, String> colProduit;
    public TableColumn<ProduitAchat, Double> colX;
    public Label LabelFactureTotal;
    public Label LabelFacture;
    public TableView<ProduitStock> tableDetails1;
    public TableColumn<ProduitStock, Double> colPrix;
    public TableColumn<ProduitStock, String> colU;

    public void doSo(){
        tableDetails.getItems().clear();
        ArrayList<ProduitAchat> produitAchats = Controller.factureDetails.getFacture().getProduits();
        tableDetails.getItems().addAll(produitAchats);
        LabelFacture.setText(Controller.factureDetails.getNom() + "         Date : " +Controller.factureDetails.getDate().toString());
        LabelFactureTotal.setText("Total = " + Controller.factureDetails.getTotal()+" DZD");


        ArrayList<ProduitStock> produitStocks = new ArrayList<>();
        for (ProduitAchat produitAchat : produitAchats) {
            produitStocks.add(produitAchat.getProduitStock());
        }
        tableDetails1.getItems().clear();
        tableDetails1.getItems().addAll(produitStocks);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableDetails.getColumns().addAll(colX,colProduit);
        colX.setCellValueFactory(new PropertyValueFactory<ProduitAchat, Double>("nbr"));
        colProduit.setCellValueFactory(new PropertyValueFactory<ProduitAchat, String>("nomProduit"));

        tableDetails1.getColumns().addAll(colPrix,colU);
        colPrix.setCellValueFactory(new PropertyValueFactory<ProduitStock, Double>("prix"));
        colU.setCellValueFactory(new PropertyValueFactory<ProduitStock, String>("unite"));
        doSo();

    }
}
