package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Setter
@Getter
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

    @OneToMany(mappedBy = "dish")
    private Set<Composition> compositions;

    public Dish() {
    }

    @Override
    public int compareTo(Dish o) {
        return nameDish.compareTo(o.nameDish);
    }

}



