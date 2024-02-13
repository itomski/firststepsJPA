package de.lubowiecki.jpa.firststeps.model;

import jakarta.persistence.*;

@Entity // Soll in der DB gespeichert werden
@Table(name = "products") // Name der Tabelle. Standard ist gleich dem Klassennamen
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p") // JPQL
public class Product {

    @Id // Ist der Primaty-Key
    @GeneratedValue // Ist autoincrement
    private int id;

    @Column(length = 50)
    private String name;

    @Column(length = 1000)
    private String description;

    private double price;

    private boolean available;

    @ManyToOne // Mehrere Produkte gehören zu einer Produktgruppe
    private ProductGroup productGroup;

    // private Set<Tag> tags;

    // private Status status = Status.OK;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }
}
