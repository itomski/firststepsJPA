package de.lubowiecki.jpa.firststeps.model;

import jakarta.persistence.*;
import org.hibernate.annotations.SortNatural;

import java.util.Set;
import java.util.TreeSet;

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

    @ManyToOne // Mehrere Produkte gehören zu einer Produktgruppe, 1zuN
    private ProductGroup productGroup;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @SortNatural
    private Set<Tag> tags = new TreeSet<>();

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

    public Set<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        if(!tags.contains(tag)) {
            this.tags.add(tag);
            tag.addProduct(this);
        }
    }
}
