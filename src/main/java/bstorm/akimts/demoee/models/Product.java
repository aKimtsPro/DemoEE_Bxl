package bstorm.akimts.demoee.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "get_all", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "remove_one", query = "DELETE FROM Product p WHERE p.id = :id")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String brand;
    private String category;
    private double price;

    public Product() {
    }

    public Product(String name, String brand, String category, double price) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    public Product(long id, String name, String marque, String category, double price) {
        this.id = id;
        this.name = name;
        this.brand = marque;
        this.category = category;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
