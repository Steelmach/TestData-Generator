package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Tomasz on 09.09.2018.
 */
public class MainWindow implements Initializable {





    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private TextField fieldAmount;

   @FXML
   private Label labelLoginName;

    @FXML
    private ChoiceBox<String> choiceBoxName;

    @FXML
    private ChoiceBox<String> choiceBoxNameOptions;

    //
    @FXML
    private ChoiceBox<String> choiceBoxLastName;

    @FXML
    private ChoiceBox<String> choiceBoxLastNameOptions;

    //
    @FXML
    private ChoiceBox<String> choiceBoxAddressName;

    @FXML
    private ChoiceBox<String> choiceBoxAddressNameOptions;

    //
    @FXML
    private ChoiceBox<String> choiceBoxPhone;

    @FXML
    private ChoiceBox<String> choiceBoxPhoneOptions;

    @FXML
    private ChoiceBox<String> choiceBoxPhoneOptionsMore;

    //
    @FXML
    private ChoiceBox<String> choiceBoxPesel;

    @FXML
    private ChoiceBox<String> choiceBoxPeselOptions;

    //
    @FXML
    private ChoiceBox<String>   choiceBoxCountry;
    @FXML
    private ChoiceBox<String>   choiceBoxCompanyy;


    @FXML
    private ChoiceBox<String>   choiceBoxNumber;

    @FXML
    private ChoiceBox<String>  choiceBoxCurrency;

    @FXML
    private ChoiceBox<String>      choiceBoxIban;

    @FXML
    private ChoiceBox<String> choiceBoxDate;

    @FXML
    private ChoiceBox<String>      choiceBoxCard;


    @FXML
    private ChoiceBox<String> choiceBoxDomain;


    @FXML
    private ChoiceBox<String>      choiceBoxAmount;

    @FXML
    private ChoiceBox<String> choiceBoxVersion;
    @FXML
    private CheckBox CheckBoxImie;

    @FXML
    private CheckBox choiceBoxCompany;

    @FXML
    private CheckBox CheckBoxNazwisko;

    @FXML
    private CheckBox CheckBoxPelnyAdres;

    @FXML
    private CheckBox CheckBoxTelefon;

    @FXML
    private CheckBox CheckBoxPesel;

    @FXML
    private CheckBox CheckBoxKraj;

    @FXML
    private ChoiceBox choiceBoxAddressNameOptionsMore;

    @FXML
    private StackPane stack;

    @FXML
    private CheckBox CheckBoxDomena;
    @FXML
    private CheckBox CheckBoxNumer;
    @FXML
    private CheckBox CheckBoxWaluta;
    @FXML
    private CheckBox CheckBoxIBAN;
    @FXML
    private CheckBox CheckBoxData;
    @FXML
    private CheckBox CheckBoxIP;
    @FXML
    private CheckBox CheckBoxKartaKred;
    @FXML
    private CheckBox CheckBoxGUID;
    @FXML
    private CheckBox CheckBoxFirma;
    @FXML
    private CheckBox CheckBoxURL;
    @FXML
    private CheckBox CheckBoxKwota;
    @FXML
    private CheckBox CheckBoxAppVersion;
    @FXML
    private CheckBox CheckBoxSHA;
    @FXML
    private CheckBox CheckBoxAll;


    @FXML
    private AnchorPane panel;
    int counter=0;
    ArrayList columnNameArray = new ArrayList();
    String schoiceBoxName;
    int ilosc;
    //
   // @FXML
    //private Button buttonAboutProgram;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBoxName.getItems().removeAll(choiceBoxName.getItems());
        choiceBoxName.getItems().addAll("Polskie", "Angielskie", "Niemieckie");
        choiceBoxName.getSelectionModel().select("Polskie");

        choiceBoxNameOptions.getItems().removeAll(choiceBoxNameOptions.getItems());
        choiceBoxNameOptions.getItems().addAll("Jednoczłonowe", "Wieloczłonowe");
        choiceBoxNameOptions.getSelectionModel().select("Jednoczłonowe");


        choiceBoxLastName.getItems().removeAll(choiceBoxLastName.getItems());
        choiceBoxLastName.getItems().addAll("Polskie", "Angielskie", "Niemieckie");
        choiceBoxLastName.getSelectionModel().select("Polskie");

        choiceBoxLastNameOptions.getItems().removeAll(choiceBoxLastNameOptions.getItems());
        choiceBoxLastNameOptions.getItems().addAll("Jednoczłonowe", "Wieloczłonowe");
        choiceBoxLastNameOptions.getSelectionModel().select("Jednoczłonowe");


        choiceBoxAddressName.getItems().removeAll(choiceBoxAddressName.getItems());
        choiceBoxAddressName.getItems().addAll("Ulica", "Miasto", "Ulica i Miasto" );
        choiceBoxAddressName.getSelectionModel().select("Ulica");

        choiceBoxAddressNameOptions.getItems().removeAll(choiceBoxAddressNameOptions.getItems());
        choiceBoxAddressNameOptions.getItems().addAll("Polski", "Angielski","Niemiecki");
        choiceBoxAddressNameOptions.getSelectionModel().select("Polski");


        choiceBoxPhone.getItems().removeAll(choiceBoxPhone.getItems());
        choiceBoxPhone.getItems().addAll("Polski", "Angielski", "Niemiecki" );
        choiceBoxPhone.getSelectionModel().select("Polski");

        choiceBoxPhoneOptions.getItems().removeAll(choiceBoxPhoneOptions.getItems());
        choiceBoxPhoneOptions.getItems().addAll("Z prefiksem", "Bez prefixa");
        choiceBoxPhoneOptions.getSelectionModel().select("Z prefiksem");

        choiceBoxPhoneOptionsMore.getItems().removeAll(choiceBoxPhoneOptionsMore.getItems());
        choiceBoxPhoneOptionsMore.getItems().addAll("Nr ze spacjami", "Nr bez spacji");
        choiceBoxPhoneOptionsMore.getSelectionModel().select("Nr ze spacjami");


        choiceBoxPesel.getItems().removeAll(choiceBoxPesel.getItems());
        choiceBoxPesel.getItems().addAll("Pełnoletni", "Niepełnoletni" );
        choiceBoxPesel.getSelectionModel().select("Pełnoletni");

        choiceBoxPeselOptions.getItems().removeAll(choiceBoxPeselOptions.getItems());
        choiceBoxPeselOptions.getItems().addAll("Kobieta", "Mężczyzna");
        choiceBoxPeselOptions.getSelectionModel().select("Kobieta");

        choiceBoxCountry.getItems().removeAll(choiceBoxCountry.getItems());
        choiceBoxCountry.getItems().addAll("Z Europy", "Z Ameryki", "Z Azji", "Pozostałe" );
        choiceBoxCountry.getSelectionModel().select("Z Europy");

        choiceBoxCompanyy.getItems().removeAll(choiceBoxCompanyy.getItems());
        choiceBoxCompanyy.getItems().addAll("Z Europy", "Z Ameryki", "Z Azji", "Pozostałe" );
        choiceBoxCompanyy.getSelectionModel().select("Z Europy");

        choiceBoxNumber.getItems().removeAll(choiceBoxNumber.getItems());
        choiceBoxNumber.getItems().addAll("L. dodatnie", "L.ujemne");
        choiceBoxNumber.getSelectionModel().select("L. dodatnie");

        choiceBoxCurrency.getItems().removeAll(choiceBoxCurrency.getItems());
        choiceBoxCurrency.getItems().addAll("Europejska","Swiatowa");
        choiceBoxCurrency.getSelectionModel().select("Europejska");

        choiceBoxIban.getItems().removeAll(choiceBoxIban.getItems());
        choiceBoxIban.getItems().addAll("Polska","Europa", "Swiat");
        choiceBoxIban.getSelectionModel().select("Polska");

        choiceBoxDate.getItems().removeAll(choiceBoxDate.getItems());
        choiceBoxDate.getItems().addAll("RRRR-MM-DD","DD/MM/RRRR", "Data i czas");
        choiceBoxDate.getSelectionModel().select("RRRR-MM-DD");

        choiceBoxCard.getItems().removeAll(choiceBoxCard.getItems());
        choiceBoxCard.getItems().addAll("Master Card", "Visa");
        choiceBoxCard.getSelectionModel().select("Visa");

        choiceBoxDomain.getItems().removeAll(choiceBoxDomain.getItems());
        choiceBoxDomain.getItems().addAll("Polska", "Inne");
        choiceBoxDomain.getSelectionModel().select("Polska");

        choiceBoxAmount.getItems().removeAll(choiceBoxAmount.getItems());
        choiceBoxAmount.getItems().addAll("> 100000", ">=100000");
        choiceBoxAmount.getSelectionModel().select("> 100000");

        choiceBoxVersion.getItems().removeAll(choiceBoxVersion.getItems());
        choiceBoxVersion.getItems().addAll("X.X.X","XX.XX.XX");
        choiceBoxVersion.getSelectionModel().select("X.X.X");

        //comment endgity


    }



    @FXML
    public void clickCloseButton(ActionEvent e1) {

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Zamykanie programu"));
        dialogLayout.setBody(new Text("Czy na pewno chcesz zamknąć program?"));

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



        @FXML
        public void clickGenerate(ActionEvent e1)
        {
                ilosc= Integer.parseInt(fieldAmount.getText().trim());

            if(CheckBoxImie.isSelected())
            {
                //System.out.println(choiceBoxName.getValue()  + " " + choiceBoxNameOptions.getValue());
                schoiceBoxName = choiceBoxName.getValue();
                counter++;
                columnNameArray.add("Imie");


            }
           if (CheckBoxNazwisko.isSelected())
            {
                System.out.println(choiceBoxLastName.getValue()  + " " + choiceBoxLastNameOptions.getValue());
                counter++;
                columnNameArray.add("Nazwisko");

            }
            if (CheckBoxPelnyAdres.isSelected())
            {
                System.out.println(choiceBoxAddressName.getValue()  + " " + choiceBoxAddressNameOptions.getValue() + " " + choiceBoxAddressNameOptionsMore.getValue());
                counter++;
                columnNameArray.add("Pełny Adres");
            }
            if (CheckBoxTelefon.isSelected())
            {
                System.out.println(choiceBoxPhone.getValue()  + " " + choiceBoxPhoneOptions.getValue() + " " + choiceBoxPhoneOptionsMore.getValue());
                counter++;
                columnNameArray.add("Telefon");
            }
            if (CheckBoxPesel.isSelected())
            {
                System.out.println(choiceBoxPesel.getValue()  + " " + choiceBoxPeselOptions.getValue() );
                counter++;
                columnNameArray.add("PESEL");

            }
             if (CheckBoxKraj.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("Kraj");
            }
            if (CheckBoxFirma.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("Firma");
            }
            if (CheckBoxNumer.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("Numer");
            }
            if (CheckBoxWaluta.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("Waluta");
            }
            if (CheckBoxIBAN.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("IBAN");
            }
            if (CheckBoxData.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("Data");
            }
            if (CheckBoxIP.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("IP");
            }
            if (CheckBoxKartaKred.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("Karta Kredytowa");
            }
            if (CheckBoxDomena.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("Domena");
            }
            if (CheckBoxGUID.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("GUID");
            }
            if (CheckBoxURL.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("URL");
            }
            if (CheckBoxKwota.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("Kwota");
            }
            if (CheckBoxAppVersion.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("App Version");
            }
            if (CheckBoxSHA.isSelected())
            {
                System.out.println(choiceBoxCountry.getValue());
                counter++;
                columnNameArray.add("SHA");
            }

            if (counter > 0 )
               {
                   try {
                       ExcelFile excelOpen = new ExcelFile(columnNameArray, counter, schoiceBoxName, ilosc);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                }

        }

                public void setTextLogin(String login){
                    labelLoginName.setText(login);
                }

                public void selectAllItems()
                {
                    if ( CheckBoxAll.isSelected()) {
                        CheckBoxImie.setSelected(true);
                        CheckBoxNazwisko.setSelected(true);
                        CheckBoxPelnyAdres.setSelected(true);
                        CheckBoxTelefon.setSelected(true);
                        CheckBoxPesel.setSelected(true);
                        CheckBoxKraj.setSelected(true);
                        CheckBoxFirma.setSelected(true);
                        CheckBoxNumer.setSelected(true);
                        CheckBoxWaluta.setSelected(true);
                        CheckBoxIBAN.setSelected(true);
                        CheckBoxData.setSelected(true);
                        CheckBoxIP.setSelected(true);
                        CheckBoxKartaKred.setSelected(true);
                        CheckBoxDomena.setSelected(true);
                        CheckBoxGUID.setSelected(true);
                        CheckBoxURL.setSelected(true);
                        CheckBoxKwota.setSelected(true);
                        CheckBoxAppVersion.setSelected(true);
                        CheckBoxSHA.setSelected(true);
                    }
                    else
                    {
                        CheckBoxImie.setSelected(false);
                        CheckBoxNazwisko.setSelected(false);
                        CheckBoxPelnyAdres.setSelected(false);
                        CheckBoxTelefon.setSelected(false);
                        CheckBoxPesel.setSelected(false);
                        CheckBoxKraj.setSelected(false);
                        CheckBoxFirma.setSelected(false);
                        CheckBoxNumer.setSelected(false);
                        CheckBoxWaluta.setSelected(false);
                        CheckBoxIBAN.setSelected(false);
                        CheckBoxData.setSelected(false);
                        CheckBoxIP.setSelected(false);
                        CheckBoxKartaKred.setSelected(false);
                        CheckBoxDomena.setSelected(false);
                        CheckBoxGUID.setSelected(false);
                        CheckBoxURL.setSelected(false);
                        CheckBoxKwota.setSelected(false);
                        CheckBoxAppVersion.setSelected(false);
                        CheckBoxSHA.setSelected(false);
                    }


                }
            }

















