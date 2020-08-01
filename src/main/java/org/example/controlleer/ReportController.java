package org.example.controlleer;

import org.example.model.Dish;
import org.example.model.EnumTable;
import org.example.model.Ingredients;
import org.example.model.Report;
import org.example.repository.DishesRepository;
import org.example.repository.IngredientsRepository;
import org.example.repository.ReportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/report")
    public String addReport(
            @RequestParam EnumTable table,
            @RequestParam String nameDish,
            @RequestParam(required = false) Integer count,
            Map<String, Object> model) {

        Dish dish = dishesRepository.findByNameDish(nameDish);
        Report report = new Report (table, dish, count);
        reportRepository.save(report);
        model.put("reportMessage", "Блюдо с названием " + nameDish + " добавлено!");

        return "report";
    }
}
