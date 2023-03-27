package com.hw3.hw3.Model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer owner_id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String addres;
    @Column(name = "height")
    private Integer height;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "owner") 
    private Set<Car> cars = new HashSet<>();
    @OneToMany
    private List<Country> countries;

    public Owner() {
        super();
    }

    public Owner(Integer owner_id, String name, String addres, Integer height, Integer weight, String description) {
        super();
        this.owner_id = owner_id;
        this.name = name;
        this.addres = addres;
        this.height = height;
        this.weight = weight;
        this.description = description;
        // this.countries = countries;
    }

    // public void setCountries(List<Country> countries) {
    //     this.countries = countries;
    // }

    public void setOwnerId(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    // public List<Country> getCountries() {
    //     return this.countries;
    // }

    public Integer getOwnerId() {
        return this.owner_id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddres() {
        return this.addres;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getDescription() {
        return this.description;
    }
}
