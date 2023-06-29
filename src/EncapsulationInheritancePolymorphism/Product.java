package EncapsulationInheritancePolymorphism;

public class Product {
    private String name;
    private Integer price;
    private Double rating;

    public Product(String name, Integer price, Double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Price: " + price + " | Rating: " + rating;
    }
}
