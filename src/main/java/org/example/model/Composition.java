package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "composition")
public class Composition {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name = "composition_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="dishes_id", nullable=false)
    private Dish dish;

    @ManyToOne
    @JoinColumn(name="ingredients_id", nullable=false)
    private Ingredients ingredients;

    @Column
    private int count;

    public Composition(){}

    public Composition(Dish dish, int count) {
        this.dish = dish;
        this.count = count;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
