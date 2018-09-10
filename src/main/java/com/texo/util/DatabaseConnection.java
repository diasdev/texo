package com.texo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        //Class.forName ("org.h2.Driver");
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jcg", "root", "toor");

        Class.forName ("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:file:~/cities", "sa", "");

        return connection;
    }

    public static void main(String[] args)
    {
        try
        {
            getConnection();
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
