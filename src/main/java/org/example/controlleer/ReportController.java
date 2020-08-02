package org.example.controlleer;

import org.example.model.Report;
import org.example.repository.DishesRepository;
import org.example.repository.IngredientsRepository;
import org.example.repository.ReportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        return new ModelAndView("report")
                .addObject("Dishes", dishesRepository.findAll())
                .addObject("ingredientsList", ingredientsRepository.findAll())
                .addObject("reportList", reportRepository.findAll());
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public String addReport(@Valid Report report,
                            Map<String, Object> model) {
        reportRepository.save(report);
        model.put("reportMessage", "Блюдо с названием " + report.getDish().getNameDish() + " добавлено!");
        return "report";
    }
}
