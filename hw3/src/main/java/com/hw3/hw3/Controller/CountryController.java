package com.hw3.hw3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hw3.hw3.Model.Country;
import com.hw3.hw3.Model.CountryDTO;
import com.hw3.hw3.Service.CountryService;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countrys")
    public ResponseEntity<List<Country>> getAllCountrys() {
        return ResponseEntity.ok().body(countryService.getAllCountrys());
    }

    @GetMapping("/countrys/{country_id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Integer country_id) {
        return ResponseEntity.ok().body(countryService.getCountryById(country_id));
    }

    @PostMapping("/countrys")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok().body(this.countryService.createCountry(country));
    }

    @PutMapping("/countrys/{country_id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Integer country_id, @RequestBody Country country) {
        country.setCountryId(country_id);
        return ResponseEntity.ok().body(this.countryService.updateCountry(country));
    }

    @DeleteMapping("/countrys/{country_id}")
    public HttpStatus deleteCountry(@PathVariable Integer country_id) {
        this.countryService.deleteCountry(country_id);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/countries/sorted")
    public List<CountryDTO> getSortedCountries() {
        return countryService.getComparison();
    }
}
