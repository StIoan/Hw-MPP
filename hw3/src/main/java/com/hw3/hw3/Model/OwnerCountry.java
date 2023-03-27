package com.hw3.hw3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "owner_country")
public class OwnerCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer owner_country_id;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    private String dateArrived;
    private String dateLeft;

    public OwnerCountry() {
        super();
    }

    public OwnerCountry(Integer owner_country_id, Owner owner, Country country, String dateArrived, String dateLeft) {
        super();
        this.owner_country_id = owner_country_id;
        this.owner = owner;
        this.country = country;
        this.dateArrived = dateArrived;
        this.dateLeft = dateLeft;
    }

    public void setOwnerCountryId(Integer id) {
        this.owner_country_id = id;
    }

    public void setOwner(Owner o) {
        this.owner = o;
    }

    public void setCountry(Country c) {
        this.country = c;
    }

    public void setDateArrival(String da) {
        this.dateArrived = da;
    }

    public void setDateLeft(String dl) {
        this.dateLeft = dl;
    }

    public Integer getOwnerCountryId() {
        return this.owner_country_id;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public Country getCountry() {
        return this.country;
    }

    public String getDateArrival() {
        return this.dateArrived;
    }

    public String getDateLeft() {
        return this.dateLeft;
    }
}
