package org.example.controlleer;

import org.example.model.Dish;
import org.example.repository.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class MenuController {

    DishesRepository dishesRepository;

    public MenuController(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String main(Model model) {
        Iterable<Dish> dishesIterable = dishesRepository.findAll();

        List<Dish> sortedDishes = StreamSupport.stream(dishesIterable.spliterator(),false)
                                                  .sorted()
                                                  .collect(Collectors.toList());
        model.addAttribute("menuDishes", sortedDishes);
        return "menu";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDishes(@Valid Dish dish){
        dishesRepository.save(dish);
        return "redirect:/menu";
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