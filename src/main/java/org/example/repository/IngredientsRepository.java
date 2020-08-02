package org.example.repository;

import org.example.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
    Ingredients findByProductName(String productName);
}
