package com.example.service;

import java.util.List;

public interface CarService <T> {
    List<T> showCars(Integer count);
}
