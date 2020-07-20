package org.example.model;
import javax.persistence.*;


@Entity
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

    public Report(int count) {
        this.count = count;
    }

    public Report(Dish dish, int count) {
        this.dish = dish;
        this.count = count;
    }

    public Report(EnumTable table, Dish dish, int count) {
        this.table = table;
        this.dish = dish;
        this.count = count;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public EnumTable getTable() {
        return table;
    }

    public void setTable(EnumTable table) {
        this.table = table;
    }
}
