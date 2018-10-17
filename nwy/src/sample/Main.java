package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen_javaFx.fxml"));
        primaryStage.setTitle("Generator danych testowych");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }


    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");//dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);

}
