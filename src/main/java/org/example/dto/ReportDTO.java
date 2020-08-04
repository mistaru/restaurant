package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.model.Dish;

@Data
@AllArgsConstructor
public class ReportDTO {
    private Dish dish;
    private Integer price;
    private Integer count;
    private Integer sum;
}
