package sample;

import Noyeau.*;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Controller implements Initializable {
    public TextField textMonnaie;
    public TextField textEncaisser;
    public TextField textRecetteDujour;
    public ComboBox<String> comboBoxCategorie;
    public ComboBox<String> comboBoxCategorie1;
    public TableColumn<ProduitStock, String> colCategorieStock;
    public TableColumn<ProduitStock, String> colCategorieStock1;
    public ComboBox<String> comboBoxRechercher;
    public Label labelRectteDuJour;
    public ComboBox<String> comboBoxMois;
    public TextField textRecetteDuMois;
    public Button btnPrint;
    public TextArea textArea;
    public CheckBox checkBox;
    public Label labelText;
    public Pane paneDepenses;
    public TextField depenseSomme;
    public ComboBox<String> depenseNature;
    public TextArea depenseDetails;
    public TableView<Depense> depenseTable;
    public TableColumn<Depense, String> colDepenseNature;
    public TableColumn<Depense, Double> colDepenseSomme;
    public TableColumn<Depense, String> colDepenseDetails;
    public TableColumn<Depense, Date> colDepenseDate;
    public Label depenseLabel;
    public ImageView logoBill;
    public Pane paneBill;
    public TextField textCategorieAjout;
    public Label labelCategorie;
    public TextField textNomMagasin;
    public Label labelMagasin;
    public TextField textSommeFois;
    public TextField textDepensesDuMois;
    public AnchorPane root;
    public TextField textBarCode;
    public TextField textBarCodeAjout;
    public TableColumn<ProduitAchat, Double> colFactureX1;
    public Pane paneManuel;
    public GridPane gridFavoris;
    public Label labelFav;
    public Label labelFavSucces;
    public Pane paneFav;
    public TableView<ProduitStock> tableFav;
    public TableColumn<ProduitStock, String> colFav;
    public TextField textQuantiteFacture;
    public TextField textYear;
    public TextField textPrixAchat;
    public TextField textPrixAchat1;
    public TableColumn<ProduitStock, Double> colPrixAchatS;
    public TextField textMontant;
    public Button btnLogin;
    @FXML private Pane paneMenu;
    @FXML private Pane paneAbout;
    @FXML private Pane paneBienvenue;
    @FXML private Pane paneAjout;
    @FXML private Pane paneHistorique;
    @FXML private Pane paneStock;
    @FXML private  Pane paneNvClient;
    @FXML private Pane paneParametre;
    @FXML private Pane paneModifier;
    @FXML private PasswordField passwordFiledMotDePasse;
    @FXML private TextField textID;
    @FXML private TextField textNom;
    @FXML private TextField textPrix;
    @FXML private TextField textQuantite;
    @FXML private ComboBox<String> ComboBoxUnite;
    @FXML private Label labelTousLesChamps;
    @FXML private Label labeSucces;
    @FXML private TableView<ProduitStock> tableStock;
    @FXML private TableColumn<ProduitStock, Long> colIdS;
    @FXML private TableColumn<ProduitStock, String> colNomS;
    @FXML private TableColumn<ProduitStock, Double> colPrixS;
    @FXML private TableColumn<ProduitStock, Double> colQuanititeS;
    @FXML private TableColumn<ProduitStock, String> colUniteS;
    @FXML private TextField textID1;
    @FXML private TextField textNom1;
    @FXML private TextField textPrix1;
    @FXML private TextField textQuantite1;
    @FXML private ComboBox<String> ComboBoxUnite1;
    @FXML private Label labelTousLesChamps1;
    @FXML private Label labeSucces1;
    @FXML private TextField textRech;
    public TextField textRech1;
    @FXML private TableView<ProduitStock> tableStock1;
    @FXML private TableColumn<ProduitStock, String> colNomS1;
    @FXML private TableColumn<ProduitStock, Double> colPrixS1;
    @FXML private TableColumn<ProduitStock, Double> colQuanititeS1;
    @FXML private TableColumn<ProduitStock, String> colUniteS1;
    @FXML private TableColumn<ProduitStock, Long> colIdS1;
    @FXML private TextField textPrixFinal;
    @FXML private TextField textSommePlus;
    @FXML private TextField textQuantitePanier;
    @FXML private TableView<ProduitAchat> tableFacture;
    @FXML private TableColumn<ProduitAchat, String> colFactureProduit;
    @FXML private TableColumn<ProduitAchat, Double> colFactureX;
    @FXML private TableView<Historique> tableHistorique;
    @FXML private TableColumn<Historique, String> colFacture;
    @FXML private TableColumn<Historique, String> colFactureTotal;
    @FXML private TableColumn<Historique, Date> colFactureDate;
    @FXML private DatePicker datepickerHist;

    public static String motDePasse = "admin";
    private ProduitStock produitStockModifier;
    private Facture factureCourante;
    private ArrayList<ProduitAchat> listeProduitFacture= new ArrayList<>();
    static ArrayList<Historique> listeHistorique = new ArrayList<>();
    static ArrayList<Depense> listeDepenses = new ArrayList<>();
    private ArrayList<String> listeCategories = new ArrayList<>();
    private ArrayList<ProduitStock> listeFav = new ArrayList<>();
    public static Historique factureDetails;
    private String magasin;
    private final StringBuffer barcode = new StringBuffer();
    private int minBarcodeLength = 5;
    private String macAdresse = null;





    //****************************************************************************************************//
    @FXML
    private void logIn(){
        if(passwordFiledMotDePasse.getText().equals(motDePasse)){
            passwordFiledMotDePasse.clear();
            paneMenu.toFront();
        }
        else{
            passwordFiledMotDePasse.clear();
            passwordFiledMotDePasse.setPromptText("Incorrect !");
        }
    }

    @FXML
    private void setPaneAjout(){
        paneAjout.toFront();
        labelTousLesChamps.setStyle("-fx-text-fill: transparent;");
        labeSucces.setStyle("-fx-text-fill: transparent;");
    }

    @FXML void setPaneAbout(){
        paneAbout.toFront();
    }

    @FXML void desetPaneAbout(){
        paneAbout.toBack();
    }

    @FXML
    private void setPaneManuel(){
        paneManuel.toFront();
        textRech1.clear();
        tableStock1.getItems().clear();
        tableStock1.getItems().addAll(Stock.stock);

    }

    @FXML
    private void setPaneFav(){
        paneFav.toFront();
        tableFav.getItems().clear();
        tableFav.getItems().addAll(listeFav);
    }

    @FXML
    private void desetPaneFav(){
        paneFav.toBack();
    }




    @FXML
    private void desetPaneManuel(){
        paneManuel.toBack();
    }



    @FXML
    private void setPaneDepenses(){
        paneDepenses.toFront();
        depenseLabel.setStyle("-fx-text-fill: transparent;");
        depenseTable.getItems().clear();
        depenseTable.getItems().addAll(listeDepenses);
    }

    @FXML
    private boolean uniqueId(){
        boolean result = true;
        for (int i = 0;i< Stock.stock.size(); i++){
            if(textID.getId().equals(Stock.stock.get(i).getId())){
                result = false;
                break;
            }
        }
        return result;
    }

    @FXML
    private void setPaneHistorique(){
        paneHistorique.toFront();
        LocalDate localDate = LocalDate.now();
        setTextRecetteDujour(localDate);
        Date date = new Date();
        LocalDate local = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = local.getMonthValue();
        comboBoxMois.setValue(String.valueOf(month));
        rechercheMois();
        try
        {
            FileInputStream fis = new FileInputStream("Historique");
            ObjectInputStream ois = new ObjectInputStream(fis);

            listeHistorique= (ArrayList<Historique>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        tableHistorique.getItems().clear();
        tableHistorique.getItems().addAll(listeHistorique);
    }

    @FXML
    private void toNvClient() {
        gridFavoris.getChildren().clear();
        for(int i = 0 ; i< listeFav.size(); i++){
            Button btn = new Button(listeFav.get(i).getName());
            btn.setPrefSize(
                    gridFavoris.getWidth() / 3,
                    gridFavoris.getHeight() / (listeFav.size() / 3)
            );
            int finalI = i;
            btn.setOnAction(e -> ajouterPanierFav(listeFav.get(finalI)));
            gridFavoris.add(btn,i % 3, i / 3);
        }

        if(listeFav.size()<9) {
            for(int i = listeFav.size() ; i< 9; i++){
                Button btn = new Button("");
                btn.setDisable(true);
                btn.setPrefSize(
                        gridFavoris.getWidth() / 3,
                        gridFavoris.getHeight() / (listeFav.size() / 3)
                );
                gridFavoris.add(btn,i % 3, i / 3);
            }
        }

        Scene scene = paneBienvenue.getScene();
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.F4) {
                nvClient();
            }
            if (e.getCode() == KeyCode.F5) {
                annulerFacture();
            }
            if (e.getCode() == KeyCode.F1) {
                setPaneManuel();
            }
            if (e.getCode() == KeyCode.F3) {
                ajouterPanier();
            }
            if (e.getCode() == KeyCode.ESCAPE) {
                desetPaneManuel();
            }

        });
        paneNvClient.toFront();
        tableStock1.getItems().clear();
        tableStock1.getItems().addAll(Stock.stock);
        listeProduitFacture = new ArrayList<>();
        tableFacture.getItems().clear();
        tableFacture.getItems().addAll(listeProduitFacture);
        factureCourante = new Facture(listeProduitFacture);
        textQuantitePanier.setText("1");
        textSommeFois.setText("1");
        textPrixFinal.clear();
        textSommePlus.clear();
        textRech1.clear();
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                textBarCode.requestFocus();
            }
        });
    }


    @FXML
    private void setPaneMenu(){
        paneMenu.toFront();

    }



    @FXML
    private void setPaneBienvenue(){
        paneBienvenue.toFront();
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                passwordFiledMotDePasse.requestFocus();
            }
        });
    }

    @FXML
    private void setPaneStock(){
        paneStock.toFront();
        tableStock.getItems().clear();
        tableStock.getItems().addAll(Stock.stock);
        labelFav.setStyle("-fx-text-fill: transparent;");
        labelFavSucces.setStyle("-fx-text-fill: transparent;");

        double total = 0;
        for(int i=0; i< Stock.stock.size(); i++){
            total = total + (Stock.stock.get(i).getPrixAchat()*Stock.stock.get(i).getQuantite());
        }
        textMontant.setText(total + " DZD");
    }


    @FXML
    private void setPaneParametre(){
        paneParametre.toFront();
        labelCategorie.setStyle("-fx-text-fill: transparent;");
        paneFav.toBack();
    }

    @FXML
    private void setPaneModifier(){
        paneModifier.toFront();
        labelTousLesChamps1.setStyle("-fx-text-fill: transparent;");
        labeSucces1.setStyle("-fx-text-fill: transparent;");
        produitStockModifier = tableStock.getSelectionModel().getSelectedItem();
        textID1.setText(String.valueOf(produitStockModifier.getId()));
        textPrixAchat1.setText(String.valueOf(produitStockModifier.getPrixAchat()));
        textNom1.setText(produitStockModifier.getName());
        textPrix1.setText(String.valueOf(produitStockModifier.getPrix()));
        textQuantite1.setText(String.valueOf(produitStockModifier.getQuantite()));
        ComboBoxUnite1.setValue(produitStockModifier.getUnite());
    }

    //****************************************************************************************************//
    @FXML
    private void retourProduit(){
        //1. Select ProduitStock : BarCode or a table
        //2. Add one to the stock of ProduitStock
        //3. Add a new facture with -prixProduitStock
        //4.
    }


    @FXML
    private void ajoutProduit() {
        if (comboBoxCategorie.getValue() == null ||ComboBoxUnite.getValue() == null || textID.getText().isEmpty() || textQuantite.getText().isEmpty() || textNom.getText().isEmpty() || textPrix.getText().isEmpty() || textPrixAchat.getText().isEmpty()) {
            labelTousLesChamps.setStyle("-fx-text-fill: #FF3232;");
            labeSucces.setStyle("-fx-text-fill: transparent;");

        } else {
            if(uniqueId()) {
                ProduitStock produitStock = new ProduitStock(textID.getText(), textNom.getText(), Double.parseDouble(textPrix.getText()),Double.parseDouble(textPrixAchat.getText()), Double.parseDouble(textQuantite.getText()), ComboBoxUnite.getSelectionModel().getSelectedItem(), comboBoxCategorie.getSelectionModel().getSelectedItem().toString());
                Stock.stock.add(produitStock);
                labelTousLesChamps.setStyle("-fx-text-fill: transparent;");
                labeSucces.setStyle("-fx-text-fill: #66B266;");
                textID.clear();
                textPrix.clear();
                textNom.clear();
                textQuantite.clear();
                textPrixAchat.clear();
                sauvgardeStock();
            }
            else{
                textID.clear();
                textID.setPromptText("ID existant");
            }
        }
    }

    @FXML
    private void test() {
        for(int i=0; i<9000; i++) {
            ProduitStock produitStock = new ProduitStock("qwerty"+i, "Produit "+i,(i+1) % 500 +2, i % 500 + 1 , 300, "Kg", "Categorie");
            Stock.stock.add(produitStock);
            sauvgardeStock();
            System.out.println(i);
        }
    }



    @FXML
    private void ajouterCategorie(){
        if(!textCategorieAjout.getText().isEmpty()){
            listeCategories.add(textCategorieAjout.getText());
            textCategorieAjout.clear();
            sauvgardeCategories();
            labelCategorie.setStyle("-fx-text-fill: green;");
            comboBoxCategorie.getItems().clear();
            comboBoxCategorie1.getItems().clear();
            comboBoxRechercher.getItems().clear();
            comboBoxCategorie.getItems().addAll(listeCategories);
            comboBoxCategorie1.getItems().addAll(listeCategories);
            comboBoxRechercher.getItems().add("Tout");
            comboBoxRechercher.getItems().addAll(listeCategories);

        }
    }

    @FXML
    private void ajouterLogo(){
        if(!textNomMagasin.getText().isEmpty()){
            magasin = textNomMagasin.getText();
            textNomMagasin.clear();
            textNomMagasin.setPromptText(magasin +" ajoute.");
            try
            {
                FileOutputStream fos = new FileOutputStream("mag.sphx");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(magasin);
                oos.close();
                fos.close();
            }
            catch (IOException ignored)
            {
            }
        }
    }

    @FXML
    private void ajoutDepense(){
        if(depenseSomme.getText().isEmpty() || depenseNature.getValue() == null){
            depenseLabel.setStyle("-fx-text-fill: #FF3232;");
        }
        else {
            Depense depense = new Depense(new Date(), Double.parseDouble(depenseSomme.getText()), depenseNature.getSelectionModel().getSelectedItem().toString(), depenseDetails.getText());
            listeDepenses.add(depense);
            sauvgardeDepenses();
            depenseTable.getItems().clear();
            depenseTable.getItems().addAll(listeDepenses);
            depenseLabel.setStyle("-fx-text-fill: transparent;");
            depenseNature.setValue(null);
            depenseSomme.clear();
            depenseDetails.clear();
        }
    }

    @FXML
    private void ajouterFav(){
        ProduitStock produitFacture = tableStock.getSelectionModel().getSelectedItem();
        if(listeFav.size() < 9){
            if(!listeFav.contains(produitFacture)){
                listeFav.add(produitFacture);
                sauvgardeFav();
            }
            labelFavSucces.setStyle("-fx-text-fill: green;");
            labelFav.setStyle("-fx-text-fill: transparent;");
        }
        else {
            labelFavSucces.setStyle("-fx-text-fill: transparent;");
            labelFav.setStyle("-fx-text-fill: red;");
        }

    }

    @FXML
    private void ajouterPanier() {
        ProduitStock produitFacture = tableStock1.getSelectionModel().getSelectedItem();
        if (produitFacture!=null && produitFacture.isAvailable()){
            Double nbr = Double.parseDouble(textQuantitePanier.getText());
            if(nbr > produitFacture.getQuantite()) {
                nbr = produitFacture.getQuantite();
                textQuantitePanier.setText(nbr +" Max");
            }

            boolean trouv = false;
            int i =0;

            while (!trouv && i!=listeProduitFacture.size() ){
                if(listeProduitFacture.get(i).getNomProduit().equals(produitFacture.getName())){
                    listeProduitFacture.get(i).setNbr(listeProduitFacture.get(i).getNbr()+nbr);
                    trouv = true;
                }
                i++;
            }

            if (!trouv) listeProduitFacture.add(new ProduitAchat(produitFacture, nbr));

            tableFacture.getItems().clear();
            tableFacture.getItems().addAll(listeProduitFacture);
            double prixFINAL = 0;
            for (ProduitAchat produitAchat : listeProduitFacture) {
                prixFINAL = prixFINAL + (produitAchat.getProduitStock().getPrix() * produitAchat.getNbr());
            }
            factureCourante.setPrixFinal(prixFINAL);
            textPrixFinal.setText(String.valueOf(prixFINAL));
            produitFacture.setQuantite(produitFacture.getQuantite()-nbr);
            tableStock1.getItems().clear();
            tableStock1.getItems().addAll(Stock.stock);
            sauvgardeStock();
            textQuantitePanier.setText("1");
        }
    }

    @FXML
    private void ajoutQuantiteFacture(){
        try{
            ProduitAchat produitFacture = tableFacture.getSelectionModel().getSelectedItem();
            if(!textQuantiteFacture.getText().isEmpty() && produitFacture!=null) {
                double nbr = Double.parseDouble(textQuantiteFacture.getText());
                double mul = produitFacture.getNbr();
                for (int i = 0; i < (mul*nbr)-mul ; i++) {
                    ajouterPanierFav(produitFacture.getProduitStock());
                }
            }
            textQuantiteFacture.clear();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    textBarCode.requestFocus();
                }
            });
        }
        catch (Exception ignored){}

    }

    private void ajouterPanierFav(ProduitStock produitFacture) {
        if (produitFacture!=null && produitFacture.isAvailable()){
            Double nbr = 1.0;
            if(nbr > produitFacture.getQuantite()) {
                nbr = produitFacture.getQuantite();
                textQuantitePanier.setText(nbr +" Max");
            }

            boolean trouv = false;
            int i =0;

            while (!trouv && i!=listeProduitFacture.size() ){
                if(listeProduitFacture.get(i).getNomProduit().equals(produitFacture.getName())){
                    listeProduitFacture.get(i).setNbr(listeProduitFacture.get(i).getNbr()+nbr);
                    trouv = true;
                }
                i++;
            }

            if (!trouv) listeProduitFacture.add(new ProduitAchat(produitFacture, nbr));

            tableFacture.getItems().clear();
            tableFacture.getItems().addAll(listeProduitFacture);
            double prixFINAL = 0;
            for (ProduitAchat produitAchat : listeProduitFacture) {
                prixFINAL = prixFINAL + (produitAchat.getProduitStock().getPrix() * produitAchat.getNbr());
            }
            factureCourante.setPrixFinal(prixFINAL);
            textPrixFinal.setText(String.valueOf(prixFINAL));
            for(int k=0; k<Stock.stock.size(); k++){
                if(produitFacture.getName().equals(Stock.stock.get(k).getName())){
                    Stock.stock.get(k).setQuantite(Stock.stock.get(k).getQuantite()-1);
                }
            }
            tableStock1.getItems().clear();
            tableStock1.getItems().addAll(Stock.stock);
            sauvgardeStock();
            textQuantitePanier.setText("1");
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    textBarCode.requestFocus();
                }
            });
        }
    }




    private void ajoutPanierCodebar(String code){
        boolean trouv = false;
        int i =0;

        textRech1.setText(code);
        rechercher1();
        ProduitAchat produitAchat = null;

        while (!trouv && i!=Stock.stock.size() ){ //trouver le produit depuis le stock
            if(code.equals(Stock.stock.get(i).getId())){
                produitAchat = new ProduitAchat(Stock.stock.get(i), 1.0);
                trouv = true;
            }
            i++;
        }

        if(!trouv){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur !");
            alert.setContentText("Produit introuvable !");
            alert.showAndWait();
        }


        if ( produitAchat != null && produitAchat.getProduitStock().isAvailable() ) { // si le produit existe et qt>0 verifier si il existe dans la facture
            trouv = false;
            i = 0;

            while (!trouv && i != listeProduitFacture.size() ) {
                if (listeProduitFacture.get(i).getNomProduit().equals(produitAchat.getNomProduit())) {
                    listeProduitFacture.get(i).setNbr(listeProduitFacture.get(i).getNbr() + 1);
                    trouv = true;
                }
                i++;
            }

            if (!trouv) listeProduitFacture.add(produitAchat);

            tableFacture.getItems().clear();
            tableFacture.getItems().addAll(listeProduitFacture);

            double prixFINAL = 0;
            for (ProduitAchat produitAchat0 : listeProduitFacture) {
                prixFINAL = prixFINAL + (produitAchat0.getProduitStock().getPrix() * produitAchat0.getNbr());
            }

            factureCourante.setPrixFinal(prixFINAL);
            textPrixFinal.setText(String.valueOf(prixFINAL));
            produitAchat.getProduitStock().setQuantite(produitAchat.getProduitStock().getQuantite()-1);
            tableStock1.getItems().clear();
            tableStock1.getItems().addAll(Stock.stock);
            sauvgardeStock();
            textQuantitePanier.setText("1");
        }
        barcode.delete(0, barcode.length());
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                textBarCode.requestFocus();
            }
        });

    }

    @FXML
    private void monnaie(){
        if(!textEncaisser.getText().isEmpty() && Double.parseDouble(textEncaisser.getText()) > Double.parseDouble(textPrixFinal.getText())){
            try {
                Double monnaieArendre = Double.parseDouble(textEncaisser.getText()) - Double.parseDouble(textPrixFinal.getText());
                textMonnaie.setText(monnaieArendre.toString()+" DZD");
            }
            catch (Exception ignored){
            }

        }
    }

    @FXML
    private void ajouterSomme() {
        if(!textSommePlus.getText().isEmpty() && Double.parseDouble(textSommePlus.getText()) > 0){
            double mul = 1;
            if(!textSommeFois.getText().isEmpty()){
                mul = Double.parseDouble(textSommeFois.getText()) ;
            }

            if(textPrixFinal.getText().isEmpty()){
                factureCourante.setPrixFinal(mul*Double.parseDouble(textSommePlus.getText()));
            }
            else{
                factureCourante.setPrixFinal(factureCourante.getPrixFinal()+(Double.parseDouble(textSommePlus.getText())*mul));
            }

            textPrixFinal.setText(String.valueOf(factureCourante.getPrixFinal()));
            monnaie();

            listeProduitFacture.add(new ProduitAchat(new ProduitStock("", "Autre",mul*Double.parseDouble(textSommePlus.getText()), 1,1, "DZD", ""), (double) 1));
            textSommePlus.clear();
            textSommeFois.setText("1");
            tableFacture.getItems().clear();
            tableFacture.getItems().addAll(listeProduitFacture);
        }


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textBarCode.requestFocus();
            }
        });
    }

    @FXML
    private void modifierProduit() {
        if (ComboBoxUnite1.getValue() == null || comboBoxCategorie1.getValue() == null || textID1.getText().isEmpty() || textQuantite1.getText().isEmpty() || textNom1.getText().isEmpty() || textPrix1.getText().isEmpty()|| textPrixAchat1.getText().isEmpty()) {
            labelTousLesChamps1.setStyle("-fx-text-fill: #FF3232;");
            labeSucces1.setStyle("-fx-text-fill: transparent;");

        } else{
            Stock.stock.remove(produitStockModifier);
            for(int i= 0; i< listeFav.size(); i++)
            {
                if(produitStockModifier.getName().equals(listeFav.get(i).getName())){
                    listeFav.remove(listeFav.get(i));
                }
            }

            ProduitStock produitStock = new ProduitStock(textID1.getText(), textNom1.getText(), Double.parseDouble(textPrix1.getText()), Double.parseDouble(textPrixAchat1.getText()) ,Double.parseDouble(textQuantite1.getText()), ComboBoxUnite1.getSelectionModel().getSelectedItem(), comboBoxCategorie1.getSelectionModel().getSelectedItem().toString());
            Stock.stock.add(produitStock);
            labelTousLesChamps1.setStyle("-fx-text-fill: transparent;");
            labeSucces1.setStyle("-fx-text-fill: #66B266;");
            textID1.clear(); textPrix1.clear(); textNom1.clear(); textQuantite1.clear(); textPrixAchat1.clear();
            sauvgardeStock();
            listeFav.add(produitStock);
            sauvgardeFav();
        }
    }

    @FXML
    private void supprimerStock(){
        ProduitStock produitStock = tableStock.getSelectionModel().getSelectedItem();
        Stock.stock.remove(produitStock);
        tableStock.getItems().clear();
        tableStock.getItems().addAll(Stock.stock);
        sauvgardeStock();
    }



    @FXML
    private void supprimerFav(){
        ProduitStock produitStock = tableFav.getSelectionModel().getSelectedItem();
        listeFav.remove(produitStock);
        tableFav.getItems().clear();
        tableFav.getItems().addAll(listeFav);
        sauvgardeFav();
    }

    @FXML
    private void supprimerNonDispo(){
        for(int i=0; i <Stock.stock.size(); i++){
            if(!Stock.stock.get(i).isAvailable()){
                Stock.stock.remove(Stock.stock.get(i));
            }
        }
        tableStock.getItems().clear();
        tableStock.getItems().addAll(Stock.stock);
        sauvgardeStock();
    }

    @FXML
    private void modifierMDP() throws IOException {
        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("motDePasse.fxml"));
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void rechercher(){
        if(textRech.getText().isEmpty()){
            tableStock.getItems().clear();
            tableStock.getItems().addAll(Stock.stock);
        }
        else {
            String result = textRech.getText();
            tableStock.getItems().clear();
            for(int i =0; i<Stock.stock.size(); i++){
                if(almostKifkif(String.valueOf(Stock.stock.get(i).getId()), result) || almostKifkif(Stock.stock.get(i).getName(), result)){
                    tableStock.getItems().add(Stock.stock.get(i));
                }
            }
        }


    }

    @FXML
    private void rechercherCategorie(){
        if(comboBoxRechercher.getValue() == null){
            tableStock1.getItems().clear();
            tableStock1.getItems().addAll(Stock.stock);
        }
        else if(comboBoxRechercher.getValue().equals("Tout")){
            tableStock1.getItems().clear();
            tableStock1.getItems().addAll(Stock.stock);
        }
        else {
            String result = comboBoxRechercher.getSelectionModel().getSelectedItem().toString();
            tableStock1.getItems().clear();
            for(int i =0; i<Stock.stock.size(); i++){
                if(result.equals(Stock.stock.get(i).getCategorie())){
                    tableStock1.getItems().add(Stock.stock.get(i));

                }
            }
        }
    }



    @FXML
    private void rechercher1(){
        if(textRech1.getText().isEmpty()){
            tableStock1.getItems().clear();
            tableStock1.getItems().addAll(Stock.stock);
        }
        else {
            String result = textRech1.getText();
            tableStock1.getItems().clear();

            for(int i =0; i<Stock.stock.size(); i++){
                if(almostKifkif(String.valueOf(Stock.stock.get(i).getId()), result) || almostKifkif(Stock.stock.get(i).getName(), result)){
                    tableStock1.getItems().add(Stock.stock.get(i));
                }
            }
        }


    }


    private boolean almostKifkif(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        char[] complet = str1.toCharArray();
        char[] result = str2.toCharArray();


        for (int i = 0; i < result.length ; i++) {
            if (complet.length < result.length) return false;
            if (complet[i] != result[i]) return false;
        }
        return true;
    }

    @FXML
    private void annulerFacture(){

        for (ProduitAchat produitAchat : listeProduitFacture) {
            int i = 0;
            boolean trouv = false;
            while (i != Stock.stock.size() && !trouv) {
                if (Stock.stock.get(i).getName().equals(produitAchat.getNomProduit())) {
                    trouv = true;
                    Stock.stock.get(i).setQuantite(Stock.stock.get(i).getQuantite() + produitAchat.getNbr());
                }
                i++;
            }
        }


        paneNvClient.toFront();
        tableStock1.getItems().clear();
        tableStock1.getItems().addAll(Stock.stock);
        listeProduitFacture = new ArrayList<>();
        tableFacture.getItems().clear();
        tableFacture.getItems().addAll(listeProduitFacture);
        factureCourante = new Facture(listeProduitFacture);
        textQuantitePanier.setText("1");
        textSommeFois.setText("1");
        textPrixFinal.clear();
        textSommePlus.clear();
        textEncaisser.clear();
        textMonnaie.clear();
        textRech1.clear();
        comboBoxRechercher.setValue(null);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                textBarCode.requestFocus();
            }
        });
        sauvgardeStock();
    }

    @FXML
    private void supprimerItemFacture(){
            ProduitAchat produitAchat = tableFacture.getSelectionModel().getSelectedItem();
            int i = 0;
            boolean trouv = false;
            while (i != Stock.stock.size() && !trouv) {
                if (Stock.stock.get(i).getName().equals(produitAchat.getNomProduit())) {
                    trouv = true;
                    Stock.stock.get(i).setQuantite(Stock.stock.get(i).getQuantite() + produitAchat.getNbr());
                }
                i++;
            }

        listeProduitFacture.remove(produitAchat);
        tableFacture.getItems().clear();
        tableFacture.getItems().addAll(listeProduitFacture);

        double prixFinal = 0;
        for (ProduitAchat achat : listeProduitFacture) {
            prixFinal = prixFinal + (achat.getProduitStock().getPrix() * achat.getNbr());
        }

        textPrixFinal.setText(String.valueOf(prixFinal));

        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                textBarCode.requestFocus();
            }
        });
    }

    @FXML
    private void sortirFacture(){
        int indx;
        for (ProduitAchat produitAchat : listeProduitFacture) {
            int i = 0;
            boolean trouv = false;
            while (i != Stock.stock.size() && !trouv) {
                if (Stock.stock.get(i).getName().equals(produitAchat.getNomProduit())) {
                    trouv = true;
                    Stock.stock.get(i).setQuantite(Stock.stock.get(i).getQuantite() + produitAchat.getNbr());
                }
                i++;
            }
        }

        paneMenu.toFront();
        tableStock1.getItems().clear();
        tableStock1.getItems().addAll(Stock.stock);
        listeProduitFacture = new ArrayList<>();
        tableFacture.getItems().clear();
        tableFacture.getItems().addAll(listeProduitFacture);
        factureCourante = new Facture(listeProduitFacture);
        textQuantitePanier.setText("1");
        textSommeFois.setText("1");
        textPrixFinal.clear();
        textSommePlus.clear();
        textEncaisser.clear();
        textMonnaie.clear();
        textRech1.clear();
        comboBoxRechercher.setValue(null);
        sauvgardeStock();
    }




    @FXML
    private void nvClient(){
        if(checkBox.isSelected()){
            print();
        }
        paneNvClient.toFront();
        factureCourante.setProduits(listeProduitFacture);
        Double prix = Double.parseDouble(textPrixFinal.getText());
        Historique historique = new Historique(factureCourante, new Date(), prix);
        listeHistorique.add(historique);
        sauvgardeHistorique();
        tableStock1.getItems().clear();
        tableStock1.getItems().addAll(Stock.stock);
        listeProduitFacture = new ArrayList<>();
        tableFacture.getItems().clear();
        tableFacture.getItems().addAll(listeProduitFacture);
        factureCourante = new Facture(listeProduitFacture);
        textQuantitePanier.setText("1");
        textSommeFois.setText("1");
        textPrixFinal.clear();
        textSommePlus.clear();
        textEncaisser.clear();
        textMonnaie.clear();
        textRech1.clear();
        comboBoxRechercher.setValue(null);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                textBarCode.requestFocus();
            }
        });

        try
        {
            FileOutputStream fos = new FileOutputStream("Fich");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(Historique.i);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }


    @FXML
    private void setTextRecetteDujour(LocalDate localDate){

        ArrayList<Historique> arrayCopy = new ArrayList<>(listeHistorique);
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dateHist = Date.from(instant);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");


        for (Historique arrayListeHistorique : listeHistorique) {
            if (!fmt.format(dateHist).equals(fmt.format(arrayListeHistorique.getDate()))) {
                arrayCopy.remove(arrayListeHistorique);
            }
        }

        Double recette = 0.0;

        for (Historique historique : arrayCopy) {
            recette = recette + historique.getTotal();
        }
        labelRectteDuJour.setText(fmt.format(dateHist));
        textRecetteDujour.setText(recette.toString()+" DZD");


    }

    @FXML
    private void afficherDetailsFacture() throws IOException {
        factureDetails = tableHistorique.getSelectionModel().getSelectedItem();
        if (factureDetails != null) {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("DetailsFacture.fxml"));
            stage.setScene(new Scene(root1));
            stage.show();
        }

    }

    @FXML
    private void rechercheMois(){
        if (comboBoxMois.getValue() != null){
            String dateInput =(comboBoxMois.getSelectionModel().getSelectedItem());
            double total =0;
            double totalDepense =0;
            tableHistorique.getItems().clear();
            for (Historique arrayListeHistorique : listeHistorique) {
                Date date = arrayListeHistorique.getDate();
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int month = localDate.getMonthValue();
                int year = localDate.getYear();
                if(dateInput.equals(String.valueOf(month)) && String.valueOf(year).equals(textYear.getText())){
                    tableHistorique.getItems().add(arrayListeHistorique);
                    total = total + arrayListeHistorique.getTotal();
                }
            }
            for (Depense arrayListeDepense : listeDepenses) {
                Date date = arrayListeDepense.getDate();
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int month = localDate.getMonthValue();
                if(dateInput.equals(String.valueOf(month))){
                    totalDepense = totalDepense + arrayListeDepense.getSomme();
                }
            }
            textRecetteDuMois.setText(total +" DZD");
            textDepensesDuMois.setText(totalDepense+" DZD");
        }
    }




    @FXML
    private void rechercherHist(){
        if(datepickerHist.getValue() != null){
            Historique h = tableHistorique.getSelectionModel().getSelectedItem();
            Historique hist = h;

            ArrayList<Historique> arrayCopy = new ArrayList<>(listeHistorique);

            LocalDate localDate = datepickerHist.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date dateHist = Date.from(instant);
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");


            for (Historique arrayListeHistorique : listeHistorique) {
                if (!fmt.format(dateHist).equals(fmt.format(arrayListeHistorique.getDate()))) {
                    arrayCopy.remove(arrayListeHistorique);
                }
            }

            tableHistorique.getItems().clear();
            tableHistorique.getItems().addAll(arrayCopy);
            setTextRecetteDujour(localDate);
        }
    }

    //****************************************************************************************************//
    @FXML
    private void sauvgardeStock(){
        try
        {
            FileOutputStream fos = new FileOutputStream("Stock");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Stock.stock);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @FXML
    private void sauvgardeDepenses(){
        try
        {
            FileOutputStream fos = new FileOutputStream("Depenses.sphx");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listeDepenses);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @FXML
    private void sauvgardeHistorique(){
        try
        {
            FileOutputStream fos = new FileOutputStream("Historique");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listeHistorique);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @FXML
    private void sauvgardeCategories(){
        try
        {
            FileOutputStream fos = new FileOutputStream("Categ.sphx");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listeCategories);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @FXML
    private void sauvgardeFav(){
        try
        {
            FileOutputStream fos = new FileOutputStream("fav.sphx");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listeFav);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    @FXML
    private void sauvgardeMac(){
        try
        {
            FileOutputStream fos = new FileOutputStream("mac.sphx");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(macAdresse);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @FXML
    private void restaurerCategories(){
        try
        {
            FileInputStream fis = new FileInputStream("Categ.sphx");
            ObjectInputStream ois = new ObjectInputStream(fis);

            listeCategories = (ArrayList<String>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ignored)
        {
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
        }
    }

    @FXML
    private void restaurerHistorique(){
        try
        {
            FileInputStream fis = new FileInputStream("Historique");
            ObjectInputStream ois = new ObjectInputStream(fis);

            listeHistorique= (ArrayList<Historique>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ignored)
        {
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
        }
    }

    @FXML
    private void restaurerStock(){
        try
        {
            FileInputStream fis = new FileInputStream("Stock");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Stock.stock = (ArrayList<ProduitStock>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ignored)
        {
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
        }
    }

    @FXML
    private void restaurerDepenses(){
        try
        {
            FileInputStream fis = new FileInputStream("Depenses.sphx");
            ObjectInputStream ois = new ObjectInputStream(fis);

            listeDepenses = (ArrayList<Depense>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ignored)
        {
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
        }
    }


    @FXML
    private void restaurerMdp(){
        try
        {
            FileInputStream fis = new FileInputStream("fich.sphx");
            ObjectInputStream ois = new ObjectInputStream(fis);

            motDePasse = (String) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ignored)
        {
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
        }
    }

    @FXML
    private void restaurerNom(){
        try
        {
            FileInputStream fis = new FileInputStream("mag.sphx");
            ObjectInputStream ois = new ObjectInputStream(fis);

            magasin = (String) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ignored)
        {
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
        }
    }


    @FXML
    private void restaurerFav(){
        try
        {
            FileInputStream fis = new FileInputStream("fav.sphx");
            ObjectInputStream ois = new ObjectInputStream(fis);

            listeFav = (ArrayList<ProduitStock>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ignored)
        {
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
        }
    }

    @FXML
    private void restaurerMac(){
        try
        {
            FileInputStream fis = new FileInputStream("mac.sphx");
            ObjectInputStream ois = new ObjectInputStream(fis);

            macAdresse = (String) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ignored)
        {
            macAdresse = null;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            macAdresse = null;
        }
    }


//****************************************************************************************************//

    private String getMacAdr(){
        try {

            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());
            return sb.toString();

        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @FXML
    private void print() {

        labelMagasin.setText(magasin);
        String s1 = String.format("%1$-10s %2$-10s %3$20s\n\n",  "Date : ", DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(LocalDate.now()), LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        String s2 = String.format("%1$-10s %2$-10s %3$20s\n", "QTY", "PRIX(U)", " PRODUITS");
        s2 = s2.concat("---------------------------------------------\n");
        s1 = s1.concat(s2);


        for (ProduitAchat produitAchat : listeProduitFacture) {
            s1 = s1.concat(String.format("%1$-10.2f %2$-10.2f %3$20s\n",  produitAchat.getNbr(),  produitAchat.getProduitStock().getPrix(),produitAchat.getNomProduit().toUpperCase()));
        }
        s1 = s1.concat("---------------------------------------------\n");
        s1 = s1.concat(String.format("%1$-10s %2$-10s %3$20s\n", "Total      :", factureCourante.getPrixFinal()+" DZD", ""));
        s1 = s1.concat("---------------------------------------------\n");
        if(!textEncaisser.getText().isEmpty() && !textMonnaie.getText().isEmpty()){
            s1 = s1.concat(String.format("%1$-10s %2$-10s %3$20s\n", "Reçu      :", textEncaisser.getText()+" DZD", ""));
            s1 = s1.concat(String.format("%1$-10s %2$-10s %3$20s\n", "Rendu    :", textMonnaie.getText(), ""));
        }
        s1 = s1.concat("\n\n      Merci de votre visite ! A bientot !\n");
        int i = 0;
        try
        {
            FileInputStream fis = new FileInputStream("Fich");
            ObjectInputStream ois = new ObjectInputStream(fis);
            i =  ois.readInt();
            ois.close();
            fis.close();
        }
        catch (IOException ignored) {}
        finally {
            s1 = s1.concat("\t\t    Facture N" + i);


            labelText.setText(s1);
            Label printArea = new Label(labelText.getText());
            printArea.setWrapText(true);
            paneBill.getChildrenUnmodifiable().forEach(node -> node.setStyle("-fx-background-color: transparent"));
            printArea.setStyle("-fx-background-color: transparent");


            Printer printer = Printer.getDefaultPrinter();
            PrinterJob printerJob = PrinterJob.createPrinterJob();
            printerJob.setPrinter(printer);

            //if (printerJob.showPrintDialog(paneBill.getScene().getWindow())) {
                if (printerJob.printPage(paneBill)) {
                    printerJob.endJob();
                    System.out.println("done printing");
                } else {
                    // failed to print
                    System.out.println("failed to print");
                }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboBoxRechercher.valueProperty().addListener((obs, oldItem, newItem) -> {
            if (newItem != null) {
                rechercherCategorie();
            }
        });
        comboBoxMois.valueProperty().addListener((obs, oldItem, newItem) -> {
            if (newItem != null) {
                rechercheMois();
            }
        });

        datepickerHist.valueProperty().addListener((obs, oldItem, newItem) -> {
            if (newItem != null) {
                rechercherHist();
            }
        });

        textBarCode.addEventFilter(KeyEvent.KEY_TYPED, (KeyEvent event) -> {
            // ENTER comes as 0x000d
            if (event.getCharacter().charAt(0) == (char) 0x000d) {
                try{
                    if (barcode.length() >= minBarcodeLength) {
                        System.out.println("barcode: " + barcode.toString());
                        ajoutPanierCodebar(barcode.toString());
                        rechercher1();
                    }
                }
                finally {
                    barcode.delete(0, barcode.length());
                }

            } else {
                barcode.append(event.getCharacter());
            }
            event.consume();
        });



        ComboBoxUnite.getItems().addAll("Mètres", "Unités", "Kg");
        ComboBoxUnite1.getItems().addAll("Mètres", "Unités", "Kg");
        comboBoxMois.getItems().addAll("1", "2","3","4","5","6","7","8","9", "10","11","12");
        depenseNature.getItems().addAll("Facture produits","Electricité","Facture d'eau","Loyer","Impots","Autre");

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        textYear.setText(String.valueOf(year));


        tableStock.getColumns().addAll(colIdS,colNomS,colPrixS,colPrixAchatS,colQuanititeS,colUniteS,colCategorieStock);
        colIdS.setCellValueFactory(new PropertyValueFactory<ProduitStock, Long>("id"));
        colNomS.setCellValueFactory(new PropertyValueFactory<ProduitStock, String>("name"));
        colPrixS.setCellValueFactory(new PropertyValueFactory<ProduitStock, Double>("prix"));
        colPrixAchatS.setCellValueFactory(new PropertyValueFactory<ProduitStock, Double>("prixAchat"));
        colQuanititeS.setCellValueFactory(new PropertyValueFactory<ProduitStock, Double>("quantite"));
        colUniteS.setCellValueFactory(new PropertyValueFactory<ProduitStock, String>("unite"));
        colCategorieStock.setCellValueFactory(new PropertyValueFactory<ProduitStock, String>("categorie"));

        depenseTable.getColumns().addAll(colDepenseDate,colDepenseDetails, colDepenseNature, colDepenseSomme);
        colDepenseDate.setCellValueFactory(new PropertyValueFactory<Depense, Date>("date"));
        colDepenseNature.setCellValueFactory(new PropertyValueFactory<Depense, String>("nature"));
        colDepenseDetails.setCellValueFactory(new PropertyValueFactory<Depense, String>("details"));
        colDepenseSomme.setCellValueFactory(new PropertyValueFactory<Depense, Double>("somme"));

        tableStock1.getColumns().addAll(colNomS1,colPrixS1,colQuanititeS1,colUniteS1);
        //colIdS1.setCellValueFactory(new PropertyValueFactory<ProduitStock, Long>("id"));
        colNomS1.setCellValueFactory(new PropertyValueFactory<ProduitStock, String>("name"));
        colPrixS1.setCellValueFactory(new PropertyValueFactory<ProduitStock, Double>("prix"));
        colQuanititeS1.setCellValueFactory(new PropertyValueFactory<ProduitStock, Double>("quantite"));
        colUniteS1.setCellValueFactory(new PropertyValueFactory<ProduitStock, String>("unite"));
        //colCategorieStock1.setCellValueFactory(new PropertyValueFactory<ProduitStock, String>("categorie"));

        tableFav.getColumns().addAll(colFav);
        colFav.setCellValueFactory(new PropertyValueFactory<ProduitStock, String>("name"));

        tableFacture.getColumns().addAll(colFactureProduit, colFactureX);
        colFactureProduit.setCellValueFactory(new PropertyValueFactory<ProduitAchat, String>("nomProduit"));
        colFactureX.setCellValueFactory(new PropertyValueFactory<ProduitAchat, Double>("nbr"));
        colFactureX1.setCellValueFactory(new PropertyValueFactory<ProduitAchat, Double>("prix"));


        tableHistorique.getColumns().addAll(colFacture, colFactureTotal, colFactureDate);
        colFacture.setCellValueFactory(new PropertyValueFactory<Historique, String>("nom"));
        colFactureTotal.setCellValueFactory(new PropertyValueFactory<Historique, String>("total"));
        colFactureDate.setCellValueFactory(new PropertyValueFactory<Historique, Date>("date"));

        restaurerMdp(); restaurerStock(); restaurerHistorique(); restaurerDepenses(); restaurerCategories(); restaurerNom(); restaurerFav();



        comboBoxCategorie.getItems().addAll(listeCategories);
        comboBoxCategorie1.getItems().addAll(listeCategories);
        comboBoxRechercher.getItems().add("Tout");
        comboBoxRechercher.getItems().addAll(listeCategories);
        passwordFiledMotDePasse.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    logIn();
                    barcode.delete(0, barcode.length());
                    event.consume();
                }
            }
        });

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                passwordFiledMotDePasse.requestFocus();
            }
        });

        Font f = null;
        try {
             f = Font.loadFont(new FileInputStream(new File("./src/Css/Fonts/digital-7.otf")), 50);
        } catch (FileNotFoundException ignored) {
        }
        textPrixFinal.setFont(f);

        restaurerMac();

        if(macAdresse == null){
            try{
                macAdresse = getMacAdr();
                sauvgardeMac();
            }
            catch (Exception ignored){}
        }
        else{
            String tmp = getMacAdr();
            if (!tmp.equals(macAdresse)){
                btnLogin.setDisable(true);
            }
            else{
                btnLogin.setDisable(false);
            }
        }
    }
}
