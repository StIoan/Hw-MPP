package com.hw3.hw3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw3.hw3.Model.OwnerCountry;
import com.hw3.hw3.Repository.OwnerCountryRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OwnerCountryService implements OwnerCountryServiceInterface {
    @Autowired
    private OwnerCountryRepo ownerCountryRepo;

    @Override
    public OwnerCountry createOwnerCountry(OwnerCountry ownerCountry) {
        return ownerCountryRepo.save(ownerCountry);
    }

    @Override
    public List<OwnerCountry> getAllOwnerCountries() {
        return this.ownerCountryRepo.findAll();
    }
}
