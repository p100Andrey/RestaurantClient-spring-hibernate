package ua.i.giggs.dao;

import ua.i.giggs.model.Dish;
import java.util.List;

public interface DishDao {
    public void addDish(Dish dish);

    public void updateDish(Dish dish);

    public void removeDish(int id);

    public Dish getDishById(int id);

    public List<Dish> listDish();
}