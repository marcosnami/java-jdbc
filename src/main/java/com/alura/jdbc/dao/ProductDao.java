package com.alura.jdbc.dao;

import com.alura.jdbc.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MarcosNami on 10/6/2017.
 */
public class ProductDao {

    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public List<Product> select() throws SQLException {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM PRODUTO;";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.execute();

            try(ResultSet rs = stmt.getResultSet()) {

                while(rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("nome");
                    String description = rs.getString("descricao");
                    products.add(new Product(id, name, description));
                }

            }

        }

        return products;
    }

    public void insert(Product product) throws SQLException {

        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?);";

        try(PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.execute();

            try(ResultSet rs = stmt.getGeneratedKeys()) {
                if(rs.next()) {
                    int id = rs.getInt("id");
                    product.setId(id);
                }
            }

        }

        System.out.println("Product inserted: " + product);

    }

    public void update(Product product) throws SQLException {

        String sql = "UPDATE PRODUTO SET NOME = ?, DESCRICAO = ? WHERE ID = ?;";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setInt(3, product.getId());
            stmt.executeUpdate();

        }

        System.out.println("Product: " + product.getId() + " was updated.");

    }

    public void delete(Product product) {

    }
}
