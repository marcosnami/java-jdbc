package com.alura.jdbc;

import com.alura.jdbc.db.Database;

import java.sql.*;

/**
 * Created by marcos.nami on 02/10/2017.
 */
public class TestSelect {

    public static void main(String[] args) throws SQLException {

        Connection connection = Database.getConnection();

        Statement statement = connection.createStatement();
        boolean result = statement.execute("Select * from produto");
        System.out.println("Statement.execute = " + result + "\n");

        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("id") + " - ");
            System.out.print(resultSet.getString("nome") + " - ");
            System.out.println(resultSet.getString("descricao"));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }

}
