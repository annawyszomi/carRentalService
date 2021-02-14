package org.example.controller;
import org.example.domain.Car;
import org.example.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/add")
    public ResponseEntity<?> addCar(@RequestBody Car car){
        carService.add(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        Optional<Car> carOptional = carService.findById(id);

        if(carOptional.isPresent()){
            carService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateCar")
    public ResponseEntity<?> updateCar(@RequestBody Car car){
        Optional<Car> carOptional = carService.update(car);

        if(carOptional.isPresent()){
            return new ResponseEntity<Optional<Car>>(carOptional,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/rentCar")
    public ResponseEntity<?> rentCar(@RequestBody Car car){
        Optional<Car> carOptional = carService.rent(car);

        if(carOptional.isPresent()){
            return new ResponseEntity<Optional<Car>>(carOptional,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cars")
    public ResponseEntity<?>findAll(){
        return new ResponseEntity<>(carService.findAll(),HttpStatus.OK);
    }
}
