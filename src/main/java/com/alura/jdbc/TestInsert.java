package com.alura.jdbc;

import com.alura.jdbc.db.Database;

import java.sql.*;

/**
 * Created by marcos.nami on 02/10/2017.
 */
public class TestInsert {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = Database.getConnection()) {
            connection.setAutoCommit(false);

        /*String name = "Notebook's i7";
        String description = "Notebook's i7 is wonderful";*/

            String sql = "Insert into produto (nome, descricao) values (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                //adiciona("Notebook", "Notebook's i5", preparedStatement);
                adiciona("TV LCD", "32 polegadas", preparedStatement);
                adiciona("Blueray", "Full HDMI", preparedStatement);

                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("Rollback done!");
            }

        }
    }

    private static void adiciona(String name, String description, PreparedStatement preparedStatement) throws SQLException {

        if (name.equals("Blueray")) {
            throw new IllegalArgumentException("An error happened");
        }

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, description);

        boolean result = preparedStatement.execute();
        System.out.println("Statement.execute = " + result + "\n");

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            System.out.print("Id: " + resultSet.getInt("id") + " gerado.\n");
        }

        resultSet.close();
    }
}
