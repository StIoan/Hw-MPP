package com.hw3.hw3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hw3.hw3.Model.OwnerCountry;
import com.hw3.hw3.Service.OwnerCountryService;

@RestController
public class OwnerCountryController {
    @Autowired
    private OwnerCountryService ownerCountryService;

    @GetMapping("/ownerCountries")
    public ResponseEntity<List<OwnerCountry>> getAllOwnerCountries() {
        return ResponseEntity.ok().body(ownerCountryService.getAllOwnerCountries());
    }

    @PostMapping("/ownerCountries")
    public ResponseEntity<OwnerCountry> createOwnerCountry(@RequestBody OwnerCountry ownerCountry) {
        return ResponseEntity.ok().body(this.ownerCountryService.createOwnerCountry(ownerCountry));
    }
}
