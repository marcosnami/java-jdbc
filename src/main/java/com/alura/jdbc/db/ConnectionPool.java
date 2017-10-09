package com.alura.jdbc.db;

import org.hsqldb.jdbc.JDBCPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by marcos.nami on 02/10/2017.
 */
public class ConnectionPool {

    private DataSource dataSource;

    public ConnectionPool() {
        JDBCPool jdbcPool = new JDBCPool();
        jdbcPool.setUrl("jdbc:hsqldb:hsql://localhost/loja-virtual");
        jdbcPool.setUser("SA");
        jdbcPool.setPassword("");
        this.dataSource = jdbcPool;
    }

    public Connection getConnection() throws SQLException {
        //Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
        Connection connection = dataSource.getConnection();
        System.out.println("ConnectionPool connection completed!\n");
        return connection;
    }
}
