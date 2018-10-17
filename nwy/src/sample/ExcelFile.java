package sample;

import javafx.event.ActionEvent;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Tomasz on 05.10.2018.
 */
public class ExcelFile {

LoginScreen loginScreen = new LoginScreen();
MainWindow mainWindow = new MainWindow();
Main main = new Main();






    public ExcelFile(ArrayList array, int arraySize, String schoiceBoxName, int ilosc) throws IOException {



        ArrayList<String> headingList = new ArrayList();
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh1 = wb.createSheet("TestData1");
        Row heading = sh1.createRow(0);




        Connection connection = DBConnection.getConnection();

        for (int k = 1; k <=ilosc; k++) {
            String sql = "select * from testdata where id=" + k;


            PreparedStatement ps = null;


            try {
                ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String imie = rs.getString(2);
                    String nazwisko = rs.getString(3);
                    String pelny_adres = rs.getString(4);
                    String telefon = rs.getString(5);
                    String pesel = rs.getString(6);
                    String email = rs.getString(7);
                    String firma = rs.getString(8);
                    String numer = rs.getString(9);
                    String waluta = rs.getString(10);
                    String iban = rs.getString(11);
                    String data = rs.getString(12);
                    String ip = rs.getString(13);
                    String karta_kredytowa = rs.getString(14);
                    String domena = rs.getString(15);
                    String guid = rs.getString(16);
                    String url = rs.getString(17);
                    String kwota = rs.getString(18);
                    String app_version = rs.getString(19);
                    String sha = rs.getString(20);



                   XSSFRow headingNext = null;
                    int i;

                    for (i = 0; i < arraySize; i++) {
                        heading.createCell(i).setCellValue((String) array.get(i));
                        headingList.add((String) array.get(i));
                        System.out.println(headingList);
                    }

                    headingNext = sh1.createRow(k);


                        for (i = 0; i < arraySize; i++) {

                            if (headingList.get(i).equals("Imie")) {
                                int numberCell = headingList.indexOf("Imie");

                                headingNext.createCell(numberCell).setCellValue(imie);
                            } else if (headingList.get(i).equals("Nazwisko")) {
                                int numberCell = headingList.indexOf("Nazwisko");
                                headingNext.createCell(numberCell).setCellValue(nazwisko);
                            } else if (headingList.get(i).equals("Pełny Adres")) {
                                int numberCell = headingList.indexOf("Pełny Adres");
                                headingNext.createCell(numberCell).setCellValue(pelny_adres);
                            } else if (headingList.get(i).equals("Telefon")) {
                                int numberCell = headingList.indexOf("Telefon");
                                headingNext.createCell(numberCell).setCellValue(telefon);
                            } else if (headingList.get(i).equals("PESEL")) {
                                int numberCell = headingList.indexOf("PESEL");
                                headingNext.createCell(numberCell).setCellValue(pesel);
                            } else if (headingList.get(i).equals("Email")) {
                                int numberCell = headingList.indexOf("Email");
                                headingNext.createCell(numberCell).setCellValue(email);
                            } else if (headingList.get(i).equals("Firma")) {
                                int numberCell = headingList.indexOf("Firma");
                                headingNext.createCell(numberCell).setCellValue(firma);
                            } else if (headingList.get(i).equals("Numer")) {
                                int numberCell = headingList.indexOf("Numer");
                                headingNext.createCell(numberCell).setCellValue(numer);
                            } else if (headingList.get(i).equals("Waluta")) {
                                int numberCell = headingList.indexOf("Waluta");
                                headingNext.createCell(numberCell).setCellValue(waluta);
                            } else if (headingList.get(i).equals("IBAN")) {
                                int numberCell = headingList.indexOf("IBAN");
                                headingNext.createCell(numberCell).setCellValue(iban);
                            } else if (headingList.get(i).equals("Data")) {
                                int numberCell = headingList.indexOf("Data");
                                headingNext.createCell(numberCell).setCellValue(data);
                            } else if (headingList.get(i).equals("IP")) {
                                int numberCell = headingList.indexOf("IP");
                                headingNext.createCell(numberCell).setCellValue(ip);
                            } else if (headingList.get(i).equals("Karta Kredytowa")) {
                                int numberCell = headingList.indexOf("Karta Kredytowa");
                                headingNext.createCell(numberCell).setCellValue(karta_kredytowa);
                            } else if (headingList.get(i).equals("Domena")) {
                                int numberCell = headingList.indexOf("Domena");
                                headingNext.createCell(numberCell).setCellValue(domena);
                            } else if (headingList.get(i).equals("GUID")) {
                                int numberCell = headingList.indexOf("GUID");
                                headingNext.createCell(numberCell).setCellValue(guid);
                            } else if (headingList.get(i).equals("URL")) {
                                int numberCell = headingList.indexOf("URL");
                                headingNext.createCell(numberCell).setCellValue(url);
                            } else if (headingList.get(i).equals("Kwota")) {
                                int numberCell = headingList.indexOf("Kwota");
                                headingNext.createCell(numberCell).setCellValue(kwota);
                            } else if (headingList.get(i).equals("App Version")) {
                                int numberCell = headingList.indexOf("App Version");
                                headingNext.createCell(numberCell).setCellValue(app_version);
                            } else if (headingList.get(i).equals("SHA")) {
                                int numberCell = headingList.indexOf("SHA");
                                headingNext.createCell(numberCell).setCellValue(sha);
                            }

                        }





                    String outputFile = "C:\\TestGenerator\\TestDataFile_"+main.sdfDate.format(main.now)+".xlsx";
                    FileOutputStream fout = new FileOutputStream(outputFile);
                    wb.write(fout);
                    fout.close();


                }
                rs.close();




            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        JOptionPane.showMessageDialog(null, "Plik został wygenerowany poprawnie",
                "SUCCESS", JOptionPane.WARNING_MESSAGE);

    }
}
