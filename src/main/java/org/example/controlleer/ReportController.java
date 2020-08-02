package org.example.controlleer;

import org.example.model.Dish;
import org.example.model.EnumTable;
import org.example.model.Ingredients;
import org.example.model.Report;
import org.example.repository.DishesRepository;
import org.example.repository.IngredientsRepository;
import org.example.repository.ReportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {

    ReportRepository reportRepository;
    DishesRepository dishesRepository;
    IngredientsRepository ingredientsRepository;

    public ReportController(ReportRepository reportRepository, DishesRepository dishesRepository, IngredientsRepository ingredientsRepository) {
        this.reportRepository = reportRepository;
        this.dishesRepository = dishesRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    @GetMapping("/report")
    public ModelAndView listReports() {
        List<Dish> dishIterable = dishesRepository.findAll();
        List<Ingredients> ingredientsList = ingredientsRepository.findAll();

        return new ModelAndView("report")
                .addObject("Dishes", dishIterable)
                .addObject("ingredientsList", ingredientsList)
                .addObject("reportList", reportRepository);
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public String addReport(@Valid Report report,
            Map<String, Object> model) {

        Dish dish = dishesRepository.findByNameDish(report.getDish().getNameDish());
        reportRepository.save(report);
        model.put("reportMessage", "Блюдо с названием " + dish + " добавлено!");

        return "report";
    }
}
