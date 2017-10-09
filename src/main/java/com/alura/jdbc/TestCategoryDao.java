package com.alura.jdbc;

import com.alura.jdbc.dao.CategoryDao;
import com.alura.jdbc.dao.ProductDao;
import com.alura.jdbc.db.ConnectionPool;
import com.alura.jdbc.model.Category;
import com.alura.jdbc.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by MarcosNami on 10/7/2017.
 */
public class TestCategoryDao {

    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionPool().getConnection();

        CategoryDao dao = new CategoryDao(connection);
        List<Category> categories = dao.select();
        for (Category category : categories) {
            System.out.println(category);
        }

    }
}
