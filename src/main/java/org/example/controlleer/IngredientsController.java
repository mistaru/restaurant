package org.example.controlleer;

import org.example.model.Ingredients;
import org.example.repository.IngredientsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class IngredientsController {

    private final IngredientsRepository ingredientsRepository;

    public IngredientsController(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("Ingredients", ingredientsRepository.findAll());
        return "ingredients";
    }

    @RequestMapping(value = "/addIngredient", method = RequestMethod.POST)
    public String add(@Valid Ingredients ingredients) {
        ingredientsRepository.save(ingredients);
        return "redirect:/ingredients";
    }

    @PostMapping("filterIng")
    public String filter(@RequestParam(required = false) String filter, Map<String, Object> model) {

        if (filter != null && !filter.isEmpty())
            model.put("Ingredients", ingredientsRepository.findByProductName(filter));
        else
            model.put("Ingredients", ingredientsRepository.findAll());
        return "ingredients";
    }

    @RequestMapping(value = "/deleteI/{id}", method = RequestMethod.GET)
    @Transactional
    public String deleteIngredients(@PathVariable Long id) {
        ingredientsRepository.deleteById(id);
        return "redirect:/ingredients";
    }

}