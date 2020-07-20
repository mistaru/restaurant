package org.example.controlleer;

import org.example.model.EnumUnit;
import org.example.model.Ingredients;
import org.example.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class IngredientsController {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @GetMapping("/ingredients")
    public String main(Map<String, Object> model) {
        Iterable<Ingredients> ingredientsIterable = ingredientsRepository.findAll();
        model.put("Ingredients", ingredientsIterable);
        return "ingredients";
    }

    @PostMapping("/ingredients")
    public String add(
            @RequestParam String productName,
            @RequestParam EnumUnit enumUnit,
            @RequestParam Integer price,
            Map<String, Object> model) {
        try {
            Ingredients ingredients = new Ingredients(productName, enumUnit, price);
            ingredientsRepository.save(ingredients);
        } catch (Exception exi) {
            model.put("errMessageI", "Ингредиент с названием " + productName + " уже существует");
        }

        Iterable<Ingredients> ingredientsIterable = ingredientsRepository.findAll();
       // model.put("IngSucces", productName + " успешно добавлено!");
        model.put("Ingredients", ingredientsIterable);

        return "ingredients";
    }

    @PostMapping("filterIng")
    public String filter(@RequestParam(required = false) String filter, Map<String, Object> model) {
        Iterable<Ingredients> ingredientsIterable;

        if (filter != null && !filter.isEmpty()) {
            ingredientsIterable = ingredientsRepository.findAllByProductName(filter);
        } else {
            ingredientsIterable = ingredientsRepository.findAll();
        }
        model.put("Ingredients", ingredientsIterable);
        return "ingredients";
    }

    @PostMapping("deleteIngredients")
    @Transactional
    public String deleteIngredients(
            @RequestParam String productName,
            Map<String, Object> model) {

        Iterable<Ingredients> dishesIterable = ingredientsRepository.deleteByProductName(productName);

        model.put("Ingredients", dishesIterable);

        return "ingredients";
    }

}