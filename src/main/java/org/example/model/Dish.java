package org.example.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "dishes")
    public class Dish implements Comparable<Dish> {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "dishes_id")
    private Long id;

    @Column(unique = true)
    @Size(min = 1, max = 100)
    private String nameDish;

    @Column
    private Integer price;

    @Column
    private String description;

    @OneToMany(mappedBy="dish")
    private Set<Composition> compositions;
    //КодБлюда,	Наименование блюда,цена,описаниие

    public Dish() {
    }

    public Dish(String nameDish, String description) {
        this.nameDish = nameDish;
        this.description = description;
    }

    public Dish(String nameDish, int price, String description) {
        this.nameDish = nameDish;
        this.price = price;
        this.description = description;
    }

    public Dish(@Size(min = 1, max = 100) String nameDish) {
        this.nameDish = nameDish;

    }

    public Dish(@Size(min = 1, max = 100) String nameDish, Integer price, String description) {
        this.nameDish = nameDish;
        this.price = price;
        this.description = description;
    }

    public int SumPrice(Dish dish, int countDish) {
        return dish.getPrice() * countDish;
    }

    public Set<Composition> getCompositions() {
        return compositions;
    }

    public void setCompositions(Set<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public int compareTo(Dish o) {
        return nameDish.compareTo(o.nameDish);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDish() {
        if (nameDish != null) {
            return nameDish;

        }
        return "";
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public Integer getPrice() {
        if (price != null)
            return price;
        else
            return 0;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        if (description != null)
            return description;
        else
            return "";
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



