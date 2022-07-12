package bstorm.akimts.demoee.models;

public class Product {

    private int id;
    private String name;
    private String brand;
    private String category;
    private double price;

    public Product(int id, String name, String marque, String category, double price) {
        this.id = id;
        this.name = name;
        this.brand = marque;
        this.category = category;
        this.price = price;
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
