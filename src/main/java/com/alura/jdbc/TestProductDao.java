package com.alura.jdbc;

import com.alura.jdbc.dao.ProductDao;
import com.alura.jdbc.db.ConnectionPool;
import com.alura.jdbc.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by MarcosNami on 10/6/2017.
 */
public class TestProductDao {

    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionPool().getConnection();

        Product product = new Product("Yellow table", "Square Table with 4 iron legs");

        ProductDao dao = new ProductDao(connection);
        dao.insert(product);

        List<Product> products = dao.select();
        for (Product produto : products) {
            System.out.println(produto);
        }

    }

}
