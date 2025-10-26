package com.example.service;

import com.example.model.Car;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Repository
public class CarServiceImpl implements CarService<Car> {

    @PersistenceContext
    private EntityManager em;

    @EventListener
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Проверяем, нет ли уже данных, чтобы избежать дублирования
        Long count = (Long) em.createQuery("select count(c) from Car c").getSingleResult();
        if (count == 0) {
            em.persist(new Car("Car1", "color1"));
            em.persist(new Car("Car2", "color2"));
            em.persist(new Car("Car3", "color3"));
            em.persist(new Car("Car4", "color4"));
            em.persist(new Car("Car5", "color5"));
        }
    }

    @Transactional
    @Override
    public List<Car> showCars(Integer count) {
        if (count == null) {
            return em.createQuery("select c from Car c", Car.class).getResultList();
        } else {
            return em.createQuery("select c from Car c", Car.class)
                    .setMaxResults(count).getResultList();
        }
    }
}
