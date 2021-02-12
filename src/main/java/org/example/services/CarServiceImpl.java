package org.example.services;

import camel.organisation.User;
import org.example.domain.Car;
import org.example.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Optional<Car> update(Car car) {
        Optional<Car> optionalCar = carRepository.findById(car.getId());

        if(optionalCar.isPresent()){
            Car existingCar = optionalCar.get();
            if(car.getBrand() !=null){
                existingCar.setBrand(car.getBrand());
            }if(car.getModel() != null){
                existingCar.setModel(car.getModel());
            }
            carRepository.save(existingCar);
            return Optional.of(existingCar);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Car> rent(Car car) {
        Optional<Car> optionalCar = carRepository.findById(car.getId());

        if(optionalCar.isPresent()){
            Car existingCar = optionalCar.get();
            if(car.getStatus()!=null){
                existingCar.setStatus(car.getStatus());
            }
            carRepository.save(existingCar);
            return Optional.of(existingCar);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Car> findById(Long id) {

        return carRepository.findById(id);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
