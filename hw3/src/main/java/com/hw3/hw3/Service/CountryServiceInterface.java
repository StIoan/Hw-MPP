package com.hw3.hw3.Service;

import java.util.List;

import com.hw3.hw3.Model.Country;

public interface CountryServiceInterface {
    Country createCountry(Country country);
    Country updateCountry(Country country);
    List<Country> getAllCountrys();
    Country getCountryById(Integer country_id);
    void deleteCountry(Integer country_id);
}
