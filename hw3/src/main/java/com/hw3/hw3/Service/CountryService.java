package com.hw3.hw3.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw3.hw3.Exception.Exception;
import com.hw3.hw3.Model.Country;
import com.hw3.hw3.Model.CountryDTO;
import com.hw3.hw3.Repository.CountryRepo;

@Service
@Transactional
public class CountryService implements CountryServiceInterface {
    @Autowired
    private CountryRepo countryRepo;

    @Override
    public Country createCountry(Country country) {
        if (country.getPopulation() >= 0 && country.getSize() > 0) {
            return countryRepo.save(country);
        } else {
            throw new Exception("The input is wrong!");
        }
    }

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> countryDb = this.countryRepo.findById(country.getCountryId());
        if (countryDb.isPresent()) {
            Country countryUpdate = countryDb.get();
            countryUpdate.setCountryId(country.getCountryId());
            countryUpdate.setDescription(country.getDescription());
            countryUpdate.setLanguage(country.getLanguage());
            countryUpdate.setName(country.getName());
            countryUpdate.setPopulation(country.getPopulation());
            countryUpdate.setSize(country.getSize());
            countryRepo.save(countryUpdate);
            return countryUpdate;
        } else {
            throw new com.hw3.hw3.Exception.Exception("Country not found!");
        }
    }

    @Override
    public List<Country> getAllCountrys() {
        return this.countryRepo.findAll();
    }

    @Override
    public Country getCountryById(Integer country_id) {
        Optional<Country> countryDb = this.countryRepo.findById(country_id);
        if (countryDb.isPresent()) {
            return countryDb.get();
        } else {
            throw new com.hw3.hw3.Exception.Exception("Country not found!");
        }
    }

    @Override
    public void deleteCountry(Integer country_id) {
        Optional<Country> countryDb = this.countryRepo.findById(country_id);
        if (countryDb.isPresent()) {
            this.countryRepo.delete(countryDb.get());
        } else {
            throw new com.hw3.hw3.Exception.Exception("Country not found!");
        }
    }   

    public List<CountryDTO> getComparison() {
        return countryRepo.findAll().stream()
            .map(c -> new CountryDTO(c.getName(), c.getPopulation(), c.getSize(), c.getLanguage(), c.getDescription()))
            .sorted().collect(Collectors.toList());
    }
}
