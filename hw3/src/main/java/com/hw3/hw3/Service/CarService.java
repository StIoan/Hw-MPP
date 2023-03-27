package com.hw3.hw3.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hw3.hw3.Exception.Exception;
import com.hw3.hw3.Model.Car;
import com.hw3.hw3.Model.CarDTO;
import com.hw3.hw3.Repository.CarRepo;

@Service
@Transactional
public class CarService implements CarServiceInterface {
    @Autowired
    private CarRepo carRepo;

    @Override
    public Car createCar(Car car) {
        if (car.getMiles() >= 0 && car.getPrice() > 0) {
            return carRepo.save(car);
        } else {
            throw new Exception("The input is wrong!");
        }
    }

    @Override
    public Car updateCar(Car car) {
        Optional<Car> carDb = this.carRepo.findById(car.getCarId());
        if (carDb.isPresent()) {
            Car carUpdate = carDb.get();
            carUpdate.setCarId(car.getCarId());
            carUpdate.setBrand(car.getBrand());
            carUpdate.setDescription(car.getDescription());
            carUpdate.setMiles(car.getMiles());
            carUpdate.setModel(car.getModel());
            carUpdate.setOwner(car.getOwner());
            carUpdate.setPrice(car.getPrice());
            carRepo.save(carUpdate);
            return carUpdate;
        } else {
            throw new Exception("Car not found!");
        }
    }

    @Override
    public List<Car> getAllCars() {
        return this.carRepo.findAll();
    }

    @Override
    public Car getCarById(Integer car_id) {
        Optional<Car> carDb = this.carRepo.findById(car_id);
        if (carDb.isPresent()) {
            return carDb.get();
        } else {
            throw new Exception("Car not found!");
        }
    }

    @Override
    public void deleteCar(Integer car_id) {
        Optional<Car> carDb = this.carRepo.findById(car_id);
        if (carDb.isPresent()) {
            this.carRepo.delete(carDb.get());
        } else {
            throw new Exception("Car not found!");
        }
    }

    @Override
    public List<Car> findByPrice(int price) {
        return carRepo.findByPriceGreaterThan(price);
    }

    public List<CarDTO> getComparison() {
        return carRepo.findAll().stream().filter(car -> car.getMiles() < 10000)
            .map(car -> new CarDTO(car.getBrand(), car.getModel(), car.getPrice(), car.getMiles(), car.getDescription()))
            .sorted().collect(Collectors.toList());
    }
}
