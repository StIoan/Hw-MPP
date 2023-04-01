package com.hw3.hw3.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hw3.hw3.Model.Car;
import com.hw3.hw3.Model.CarDTO;
import com.hw3.hw3.Service.CarService;

@RestController
@CrossOrigin("http://localhost:3000")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok().body(carService.getAllCars());
    }

    @GetMapping("/carsId")
    public ResponseEntity<List<Integer>> getAllCarsIds() {
        List<Car> list = carService.getAllCars();
        List<Integer> cars = new ArrayList<>();
        for (Car car : list) {
            cars.add(car.getCarId());
        }
        return ResponseEntity.ok().body(cars);
    }

    @GetMapping("/cars/{car_id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer car_id) {
        return ResponseEntity.ok().body(carService.getCarById(car_id));
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.ok().body(this.carService.createCar(car));
    }

    @PutMapping("/cars/{car_id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer car_id, @RequestBody Car car) {
        car.setCarId(car_id);
        return ResponseEntity.ok().body(this.carService.updateCar(car));
    }

    @DeleteMapping("/cars/{car_id}")
    public HttpStatus deleteCar(@PathVariable Integer car_id) {
        this.carService.deleteCar(car_id);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/cars/filterByPrice/{price}")
    public List<Car> getAllCars(@PathVariable int price) {
        return carService.findByPrice(price);
    }

    @GetMapping(value = "/cars/sorted")
    public List<CarDTO> getSortedCars() {
        return carService.getComparison();
    }
}
