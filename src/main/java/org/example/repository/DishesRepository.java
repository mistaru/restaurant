package org.example.repository;

import org.example.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishesRepository extends JpaRepository<Dish,Long> {

    Dish findByNameDish(String nameDish);
    List<Dish> findAllByNameDish(String nameDish);

}
