package com.hw3.hw3.Model;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer country_id;
    @Column(name = "name")
    private String name;
    @Column(name = "population")
    private Integer population;
    @Column(name = "size")
    private Integer size;
    @Column(name = "language")
    private String language;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "countries")
    private List<Owner> owners;

    public Country() {
        super();
    }

    public Country(Integer country_id, String name, Integer population, Integer size, String language, String description) {
        super();
        this.country_id = country_id;
        this.name = name;
        this.population = population;
        this.size = size;
        this.language = language;
        this.description = description;
    }

    public void setCountryId(Integer id) {
        this.country_id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCountryId() {
        return this.country_id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPopulation() {
        return this.population;
    }

    public Integer getSize() {
        return this.size;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getDescription() {
        return this.description;
    }
}