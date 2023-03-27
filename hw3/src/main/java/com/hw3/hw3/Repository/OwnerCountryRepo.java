package com.hw3.hw3.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hw3.hw3.Model.OwnerCountry;

public interface OwnerCountryRepo extends JpaRepository<OwnerCountry, Integer> {
    
}
