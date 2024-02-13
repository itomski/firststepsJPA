package de.lubowiecki.jpa.firststeps.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product_groups")
public class ProductGroup {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    // Eine ProduktGruppe enthält mehrere Produkte
    @OneToMany(mappedBy = "productGroup", cascade = CascadeType.PERSIST)
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
