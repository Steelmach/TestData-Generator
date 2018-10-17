package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable{

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;

    @FXML
    private Label textErrorLabel;

    @FXML
    private Button closeButton;

    @FXML
    private ImageView loaderView;


    @FXML
    private StackPane stack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

       loaderView.setVisible(false);
    }



    @FXML
    public void clickLoginButton(ActionEvent e){


        String loginStr = loginField.getText().trim();
        String passwordStr = passwordField.getText().trim();

            boolean isExist = false;
            String userPassword="";
            String userType="";

            Connection connection = DBConnection.getConnection();
            String sql = "select * from Users where Username='"+ loginStr+"'";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                isExist=true;
                userPassword=rs.getString(3);
                userType=rs.getString(6);

            }

            if(isExist){
                if(passwordStr.equals(userPassword)){
                    textErrorLabel.setText("");

                    loaderView.setVisible(true);
                    PauseTransition pt = new PauseTransition();
                    pt.setDuration(Duration.seconds(3));
                    pt.setOnFinished((ActionEvent ev) -> {

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow_javaFx.fxml"));


                        Parent  root = null;
                        try {
                            root = (Parent) loader.load();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }


                        MainWindow mainWindow = loader.getController();
                        mainWindow.setTextLogin(loginStr);

                        Stage MainWindowStage = new Stage();
                        MainWindowStage.setScene(new Scene(root));
                        MainWindowStage.setResizable(false);
                        MainWindowStage.setTitle("Generator danych testowych");
                        MainWindowStage.show();
                        loginButton.getScene().getWindow().hide();


                    });


                    pt.play();
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


        if (loginStr.length() < 1) {

            textErrorLabel.setText("Pole Login jest puste!");

        } else if ((passwordStr.length() < 1))
        {
            textErrorLabel.setText("Pole Hasło jest puste!");

        }
        else if (!passwordStr.equals(userPassword)){
            textErrorLabel.setText("Dane logowania są nieprawidłowe!");

        }

    }


    @FXML
    public void clickCloseButton(ActionEvent e1)
    {

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new javafx.scene.text.Text("Zamykanie programu"));
        dialogLayout.setBody(new javafx.scene.text.Text("Czy na pewno chcesz zamknąć program?"));

        JFXButton ok = new JFXButton("Tak");
        JFXButton cancel = new JFXButton("Nie");

        JFXDialog dialog = new JFXDialog(stack ,dialogLayout,JFXDialog.DialogTransition.CENTER);


        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

        dialogLayout.setActions(ok,cancel);
        dialog.show();




    }
}
