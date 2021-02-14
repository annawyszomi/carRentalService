package org.example.controller;

import org.example.domain.Car;
import org.example.repositories.CarRepository;
import org.example.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class FECarController {

    @Autowired
    CarService carService;

    @Autowired
    CarRepository carRepository;

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String addCar(@Valid Car car, BindingResult errors) {
        if (errors.hasErrors()) {
            return "addCar";
        }
        carService.add(car);
        return "redirect:/";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.GET)
    public String showRegisterCarForm(Car car) {
        return "addCar";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        Car car = carService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        carService.delete(car.getId());
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showUpdateCarForm(@PathVariable Long id, Model model) {
        Car car = carService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        model.addAttribute("car", car);
        return "editCar";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateCar(@PathVariable("id") Long id, @Valid Car car, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            car.setId(id);
            return "editCar";
        }
        carService.update(car);
        model.addAttribute("cars", carService.findAll());
        return "redirect:/";
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.GET)
    public String rentCar(@PathVariable("id") Long id, Model model) {
        Car car = carService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        carService.rent(car);
        return "redirect:/";
    }

    @GetMapping("/")
    public String showAllCars(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "index";
    }

}
