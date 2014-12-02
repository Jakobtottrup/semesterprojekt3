package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnecter {
//    private static String url = "jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk:5432/sb3_2014_group_7_db";
//    private static String username = "sb3_2014_group_7";
//    private static String password = "CUtmw8pG";

    //===================== LOCALHOST================//
    private static String url = "jdbc:postgresql://localhost:5432/semesterprojekt";
    private static String username = "postgres";
    private static String password = "1";


    public static void main(String filename) throws IOException, ClassNotFoundException
    {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream(filename);
        props.load(in);


        String driver = props.getProperty("jdbc.driver");
        url = props.getProperty("jdbc.url");
        username = props.getProperty("jdbc.username");
        if(username == null) username = "";
        password = props.getProperty("jdbc.password");
        if(password == null) password ="";
        if(driver !=null)
            Class.forName(driver);

    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }

}
