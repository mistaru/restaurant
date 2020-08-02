package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

}
