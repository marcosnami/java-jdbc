package com.alura.jdbc.model;

/**
 * Created by MarcosNami on 10/6/2017.
 */
public class Product {

    private int id;
    private String name;
    private String description;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Product(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
