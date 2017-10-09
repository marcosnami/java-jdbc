package com.alura.jdbc.dao;

import com.alura.jdbc.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MarcosNami on 10/7/2017.
 */
public class CategoryDao {

    private Connection connection;

    public CategoryDao(Connection connection) {
        this.connection = connection;
    }

    public List<Category> select() throws SQLException {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM CATEGORIA;";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
            try(ResultSet rs = stmt.getResultSet()) {
                while(rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("nome");
                    categories.add(new Category(id, name));
                }
            }
        }
        return categories;
    }
}
