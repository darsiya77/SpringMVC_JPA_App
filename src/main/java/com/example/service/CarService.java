package com.example.service;

import java.util.List;

public interface CarService <Car> {
    List<Car> showCars(Integer count);
}
