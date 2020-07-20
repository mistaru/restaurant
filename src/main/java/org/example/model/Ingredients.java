package org.example.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ingredients_id")
    private Long id;

    @Column(unique = true)
    @Size(min = 1, max = 100)
    private String productName;

    @Column
    @Enumerated(EnumType.STRING)
    private EnumUnit enumUnit;

    @Column
    private int price;

    @OneToMany(mappedBy = "ingredients")
    private Set<Composition> compositionI;

    public Ingredients() {
    }

    public Ingredients(String productName) {
        this.productName = productName;
    }

    public Ingredients(String productName, EnumUnit enumUnit, int price) {
        this.productName = productName;
        this.enumUnit = enumUnit;
        this.price = price;
    }


    public int SumPriceIng(Ingredients ingredients, int countDish) {
        return ingredients.getPrice() * countDish;
    }

    public EnumUnit getEnumUnit() {
        return enumUnit;
    }

    public void setEnumUnit(EnumUnit enumUnit) {
        this.enumUnit = enumUnit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<Composition> getCompositionI() {
        return compositionI;
    }

    public void setCompositionI(Set<Composition> compositionI) {
        this.compositionI = compositionI;
    }
}
