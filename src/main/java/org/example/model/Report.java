package org.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.enume.EnumTable;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "reserv")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "reserv_id")
    private int id;

    @Column(name = "table_number")
    @Enumerated(EnumType.STRING)
    private EnumTable table;

    @ManyToOne
    @JoinColumn(name = "dishes_id", nullable = false)
    private Dish dish;

    @Column
    private int count;

    public Report() {
    }

    public Report(EnumTable table, Dish dish, Integer count) {
        this.table = table;
        this.dish = dish;
        this.count = count;
    }
}
