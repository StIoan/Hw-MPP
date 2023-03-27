package com.hw3.hw3.Service;
import java.util.List;
import com.hw3.hw3.Model.Car;

public interface CarServiceInterface {
    Car createCar(Car car);
    Car updateCar(Car car);
    List<Car> getAllCars();
    Car getCarById(Integer car_id);
    void deleteCar(Integer car_id);
    public List<Car> findByPrice(int price);
    
}
