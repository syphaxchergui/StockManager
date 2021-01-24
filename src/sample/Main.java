package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Gestionnaire de stock");
        Image ico = new Image("Image/logoF.png");
        primaryStage.getIcons().add(ico);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        //primaryStage.resizableProperty().setValue(Boolean.FALSE);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
