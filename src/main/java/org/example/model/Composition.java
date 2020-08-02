package org.example.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "composition")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "composition_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "dishes_id", nullable = false)
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "ingredients_id", nullable = false)
    private Ingredients ingredients;

    @Column
    private int count;

    public Composition() {}

}
