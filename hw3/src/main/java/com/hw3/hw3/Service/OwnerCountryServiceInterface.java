package com.hw3.hw3.Service;

import java.util.List;

import com.hw3.hw3.Model.OwnerCountry;

public interface OwnerCountryServiceInterface {
    OwnerCountry createOwnerCountry(OwnerCountry ownerCountry);
    // OwnerCountry updateOwnerCountry(OwnerCountry ownerCountry);
    List<OwnerCountry> getAllOwnerCountries();
    // OwnerCountry getOwnerCountryById(Integer owner_country_id);
    // void deleteOwnerCountry(Integer owner_country_id);
}
