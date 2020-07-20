package org.example.repository;


import org.example.model.Composition;
import org.example.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompositionRepository extends JpaRepository<Composition,Long> {
    @Query(value = "select i.ingredients_id from composition i where i.dishes_id = :id", nativeQuery = true)
    List<Ingredients> findListIngredients(@Param("id") int id);

    List<Composition> findByDishId(int id);
}
