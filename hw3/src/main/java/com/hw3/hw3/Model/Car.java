package com.hw3.hw3.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer car_id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private Integer price;
    @Column(name = "miles")
    private Integer miles;
    @Column(name = "description")
    private String description;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Car() {
        super();
    }

    public Car(Integer car_id, String brand, String model, Integer price, Integer miles, String description, Owner owner) {
        super();
        this.car_id = car_id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.miles = miles;
        this.description = description;
        this.owner = owner;
    }

    public void setCarId(Integer car_id) {
        this.car_id = car_id;
    }

    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    public void setModel(String newModel) {
        this.model = newModel;
    }

    public void setOwner(Owner newOwner) {
        this.owner = newOwner;
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

    public Integer getCarId() {
        return this.car_id;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public Owner getOwner() {
        return this.owner;
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
}
