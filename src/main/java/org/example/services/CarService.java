package org.example.services;

import org.example.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    void add(Car car);
    void delete(Long id);
    Optional<Car> update (Car car);
    Optional<Car> rent (Car car);
    Optional<Car> findById(Long id);
    List<Car> findAll();
}
