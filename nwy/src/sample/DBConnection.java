package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Tomasz on 10.10.2018.
 */
public class DBConnection {

    static Connection connection= null;
    public static Connection getConnection (){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/testdategen";
            connection = DriverManager.getConnection(url,"root","");
            System.out.println("Connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
