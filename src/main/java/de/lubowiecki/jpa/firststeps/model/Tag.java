package de.lubowiecki.jpa.firststeps.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag implements Comparable<Tag> {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 20, unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Product> products = new HashSet<>();

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if(!products.contains(product)) {
            this.products.add(product);
            product.addTag(this);
        }
    }

    @Override
    public int compareTo(Tag other) {
        return name.compareTo(other.name);
    }
}
