package com.alura.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by marcos.nami on 02/10/2017.
 */
public class Database {

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
        System.out.println("Database connection completed!\n");
        return connection;
    }
}
