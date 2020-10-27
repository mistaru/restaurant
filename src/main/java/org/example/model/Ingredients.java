package org.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.enume.EnumUnit;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Setter
@Getter
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

}
