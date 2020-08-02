package org.example.controlleer;

import org.example.dto.IngredientDTO;
import org.example.dto.OverallDTO;
import org.example.dto.ReportDTO;
import org.example.model.*;
import org.example.repository.DishesRepository;
import org.example.repository.IngredientsRepository;
import org.example.repository.ReportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Controller
public class ScoreController {

    ReportRepository reportRepository;
    DishesRepository dishesRepository;
    IngredientsRepository ingredientsRepository;

    public ScoreController(ReportRepository reportRepository, DishesRepository dishesRepository, IngredientsRepository ingredientsRepository) {
        this.reportRepository = reportRepository;
        this.dishesRepository = dishesRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    @GetMapping("/score")
    public ModelAndView listScore() {
        List<Dish> dishIterable = dishesRepository.findAll();
        List<Ingredients> ingredientsList = ingredientsRepository.findAll();
        List<Report> reportList = reportRepository.findAll();

        return new ModelAndView("score")
                .addObject("Dishes", dishIterable)
                .addObject("ingredientsList", ingredientsList)
                .addObject("reportList", reportRepository);
    }

    @PostMapping("/score")
    public String scoreMethod(
            @RequestParam EnumTable table,
            Map<String, Object> model) {

        Map<Dish, List<Report>> reportList = reportRepository.findAll().stream()
                .filter(rep -> rep.getTable() == table)
                .collect(groupingBy(Report::getDish));

        List<ReportDTO> reports = new ArrayList<>();
        int overallSum = 0;
        for (Dish d : reportList.keySet()) {
            Integer price = d.getPrice();
            Integer currCount = reportList.get(d).stream().mapToInt(Report::getCount).sum();
            int sum = currCount * d.getPrice();

            overallSum = overallSum + sum;
            reports.add(new ReportDTO(d, price, currCount, sum));
        }

        Map<Ingredients, Integer> ingCount = new HashMap<>();
        for (ReportDTO rep : reports) {
            for (Composition comp : rep.getDish().getCompositions()) {
                Integer c = rep.getCount();
                Ingredients ing = comp.getIngredients();
                if (ingCount.get(ing) != null) ingCount.put(ing, c * (ingCount.get(ing) + comp.getCount()));
                else ingCount.put(ing, c * comp.getCount());
            }
        }

        List<IngredientDTO> ingredientsDTO = new ArrayList<>();
        ingCount.keySet()
                .forEach(ing -> ingredientsDTO.add(new IngredientDTO(ing.getProductName(), ingCount.get(ing))));

        int overallIngPrice = 0;
        for (IngredientDTO ingDto : ingredientsDTO) {
            Ingredients ing = ingredientsRepository.findByProductName(ingDto.getName());
            overallIngPrice += (ing.getPrice() * ingDto.getCount());
        }

        OverallDTO overallDto = new OverallDTO();
        overallDto.setOverallSum(overallSum);
        overallDto.setOverallIngSum(overallIngPrice);

        model.put("overall1", overallDto);
        model.put("Reports", reports);
        model.put("ingredients", ingredientsDTO);

        return "score";
    }
}

