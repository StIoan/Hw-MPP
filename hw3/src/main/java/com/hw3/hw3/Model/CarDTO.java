package com.hw3.hw3.Model;

public class CarDTO implements Comparable<CarDTO> {
    private String brand;
    private String model;
    private Integer price;
    private Integer miles;
    private String description;

    public CarDTO(String brand, String model, Integer price, Integer miles, String description) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.miles = miles;
        this.description = description;
    }

    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    public void setModel(String newModel) {
        this.model = newModel;
    }

    public void setPrice(Integer newPrice) {
        this.price = newPrice;
    }

    public void setMiles(Integer newMiles) {
        this.miles = newMiles;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getMiles() {
        return this.miles;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public int compareTo(CarDTO c) {
        return Integer.compare(this.getPrice(), c.getPrice());
    }
}
