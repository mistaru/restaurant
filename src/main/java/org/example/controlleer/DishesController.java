package org.example.controlleer;


import org.example.model.Composition;
import org.example.model.Dish;
import org.example.model.Ingredients;
import org.example.repository.CompositionRepository;
import org.example.repository.DishesRepository;
import org.example.repository.IngredientsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/dishes")
    public ModelAndView main() {
        Iterable<Dish> dishesIterable = dishesRepository.findAll();
        List<Ingredients> ingredientsList = ingredientsRepository.findAll();
        return new ModelAndView("dishes")
                .addObject("Dishes", dishesIterable)
                .addObject("ingredientsList", ingredientsList);
    }

    @PostMapping("/dishes")
    public String addDishes(
            @RequestParam String nameDish,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) String description,
            Map<String, Object> model) {
        try {

            Dish dish = new Dish(nameDish, price, description);

            dishesRepository.save(dish);
            model.put("DishMessage", "Блюдо с названием " + nameDish + " добавлен!");

        } catch (Exception ex) {
            model.put("errMessage", "Блюдо с названием " + nameDish + " уже существует");
        }

        Iterable<Dish> dishesIterable = dishesRepository.findAll();

        model.put("Dishes", dishesIterable);

        return "dishes";
    }

    @PostMapping("delete")
    @Transactional
    public String deleteDishes(
            @RequestParam String nameDish,
            Map<String, Object> model) {

        Iterable<Dish> dishesIterable = dishesRepository.deleteByNameDish(nameDish);
        dishesIterable = dishesRepository.findAll();

        model.put("Dishes", dishesIterable);
        return "dishes";
    }

    @GetMapping("/addIngredients")
    @Transactional
    public ModelAndView listDishes() {
        List<Dish> dishIterable = dishesRepository.findAll();
        List<Ingredients> ingredientsList = ingredientsRepository.findAll();

        return new ModelAndView("addIngredients")
                .addObject("Dishes", dishIterable)
                .addObject("ingredientsList", ingredientsList);
    }

    @PostMapping("/addIngredients")
    public String addIngredients(
            @RequestParam String nameDish,
            @RequestParam String productName,
            @RequestParam Integer count,
            Map<String, Object> model) {

        List<Ingredients> ingredientsList = ingredientsRepository.findAllByProductName(productName);
        Dish dish = dishesRepository.findByNameDish(nameDish);
        Ingredients ingredients1 = ingredientsList.get(0);
        Composition composition = new Composition();
        composition.setDish(dish);
        composition.setIngredients(ingredients1);
        composition.setCount(count);

    /*    List<Dish> dishes1 = dishesRepository.findAll();
        d
        dishes1.get(0).getCompositions().iterator().next().getIngredients().getProductName();
        int a = dishes1.get(0).getCompositions().iterator().next().getIngredients().getPrice();
*/

        compositionRepository.save(composition);

        Iterable<Dish> dishesIterable = dishesRepository.findAll();
        dishesRepository.save(dish);

        model.put("addIngredient", dishesIterable);

        return "addIngredients";
    }
}