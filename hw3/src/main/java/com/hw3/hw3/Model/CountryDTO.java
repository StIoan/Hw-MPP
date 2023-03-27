package com.hw3.hw3.Model;

public class CountryDTO implements Comparable<CountryDTO> {
    private String name;
    private Integer population;
    private Integer size;
    private String language;
    private String description;

    public CountryDTO(String name, Integer population, Integer size, String language, String description) {
        this.name = name;
        this.population = population;
        this.size = size;
        this.language = language;
        this.description = description;
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

    @Override
    public int compareTo(CountryDTO c) {
        return Integer.compare(this.getPopulation(), c.getPopulation());
    }
}
