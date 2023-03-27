package com.hw3.hw3.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hw3.hw3.Model.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {
    List<Car> findByPriceGreaterThan(int price);
}
