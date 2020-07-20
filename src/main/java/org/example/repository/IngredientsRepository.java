package org.example.repository;

import org.example.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsRepository extends JpaRepository<Ingredients,Long> {
    Ingredients findByProductName(String productName);
    List<Ingredients> findAllByProductName(String productName);
    List<Ingredients> deleteByProductName(String productName);

}
