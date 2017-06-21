package ua.i.giggs.model;

import javax.persistence.*;

@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @Column(name = "dishid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dishid;

    @Column(name = "dishname")
    private String dishname;

    @Column(name = "category")
    private String category;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "cost")
    private double cost;

    @Column(name = "weight")
    private double weight;

    public int getDishid() {
        return dishid;
    }

    public void setDishid(int dishid) {
        this.dishid = dishid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishid=" + dishid +
                ", dishname='" + dishname + '\'' +
                ", category='" + category + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}