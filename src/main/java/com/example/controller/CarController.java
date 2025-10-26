package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.model.Car;
import com.example.service.CarService;

@Controller
public class CarController {

    private final CarService<Car> carService;

    @Autowired
    public CarController(CarService<Car> carService ) {
        this.carService = carService;
    }

//	@GetMapping(value = "/cars")
//	public String printCars(ModelMap model) {
//		model.addAttribute("cars", carDAO.carsList());
//		return "cars";
//	}


//	@GetMapping(value = "/cars/{id}")
//	public String show(@PathVariable("id") int id, ModelMap model) {
//		model.addAttribute("carsCount", carDAO.showCars(id));
//		return "show";
//	}

    @GetMapping(value = "/cars")
    public String show(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        model.addAttribute("cars", carService.showCars(count));
        return "CarService/cars";
    }

}