package org.example.controlleer;

import org.example.model.Dish;
import org.example.repository.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class MenuController {

    @Autowired
    DishesRepository dishesRepository;

    @GetMapping("/menu")
    public String main(Map<String, Object> model) {
        Iterable<Dish> dishesIterable = dishesRepository.findAll();

        List<Dish> sortedDishes = StreamSupport.stream(dishesIterable.spliterator(),false)
                                                  .sorted()
                                                  .collect(Collectors.toList());

        model.put("menuDishes", sortedDishes);
        return "menu";
    }

    @PostMapping("filter")
    public String filter(@RequestParam(required=false) String filter, Map<String, Object> model) {
        Iterable<Dish> dishesIterable;

        if (filter != null && !filter.isEmpty()) {
            dishesIterable = dishesRepository.findAllByNameDish(filter);
        } else {
            dishesIterable = dishesRepository.findAll();
        }
        model.put("menuDishes", dishesIterable);
        return "menu";
    }

}