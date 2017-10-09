package com.alura.jdbc;

import com.alura.jdbc.db.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by marcos.nami on 02/10/2017.
 */
public class TestDelete {

    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionPool().getConnection();

        Statement statement = connection.createStatement();

        boolean result = statement.execute("Delete from produto where id > 3");
        System.out.println("Statement.execute = " + result + "\n");

        int updateCount = statement.getUpdateCount();
        if (updateCount > 1) {
            System.out.println(updateCount + " records were removed from produto table.");
        } else {
            System.out.println(updateCount + " record was removed from produto table.");
        }

        statement.close();
        connection.close();
    }
}
