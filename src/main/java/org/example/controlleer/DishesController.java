package org.example.controlleer;

import org.example.model.Composition;
import org.example.model.Dish;
import org.example.model.Ingredients;
import org.example.repository.CompositionRepository;
import org.example.repository.DishesRepository;
import org.example.repository.IngredientsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class DishesController {

    private final DishesRepository dishesRepository;
    private final IngredientsRepository ingredientsRepository;
    private final CompositionRepository compositionRepository;

    public DishesController(DishesRepository dishesRepository, IngredientsRepository ingredientsRepository, CompositionRepository compositionRepository) {
        this.dishesRepository = dishesRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.compositionRepository = compositionRepository;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Transactional
    public String deleteDishes(@PathVariable Long id) {
        dishesRepository.deleteById(id);
        return "redirect:/menu";
    }

    @GetMapping("/addIngredients")
    public ModelAndView listDishes() {
        List<Dish> dishIterable = dishesRepository.findAll();
        List<Ingredients> ingredientsList = ingredientsRepository.findAll();
        Iterable<Composition> compositions = compositionRepository.findAll();


        return new ModelAndView("addIngredients")
                .addObject("Dishes", dishIterable)
                .addObject("ingredientsList", ingredientsList)
                .addObject("compositions", compositions);

    }

    @PostMapping("/addIngredients")
    public String addIngredients(
            @RequestParam String nameDish,
            @RequestParam String productName,
            @RequestParam Integer count,
            Map<String, Object> model) {

        Ingredients ingredientsList = ingredientsRepository.findByProductName(productName);
        Dish dish = dishesRepository.findByNameDish(nameDish);
        Composition composition = new Composition();
        composition.setDish(dish);
        composition.setIngredients(ingredientsList);
        composition.setCount(count);

        compositionRepository.save(composition);

        Iterable<Dish> dishesIterable = dishesRepository.findAll();
        dishesRepository.save(dish);

        Iterable<Composition> compositions = compositionRepository.findAll();


        model.put("addIngredient", dishesIterable);
        model.put("compositions", compositions);

        return "addIngredients";
    }

}