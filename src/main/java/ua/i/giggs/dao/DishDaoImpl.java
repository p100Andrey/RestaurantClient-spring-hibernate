package ua.i.giggs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.i.giggs.model.Dish;

import java.util.List;

@Repository
public class DishDaoImpl implements DishDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDish(Dish dish) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dish);
    }

    @Override
    public void updateDish(Dish dish) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(dish);
    }

    @Override
    public void removeDish(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Dish dish = (Dish) session.load(Dish.class, new Integer(id));

        if (dish != null) {
            session.delete(dish);
        }
    }

    @Override
    public Dish getDishById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Dish dish = (Dish) session.load(Dish.class, new Integer(id));

        return dish;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Dish> listDish() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Dish> dishList = session.createQuery("from Dish").list();

        return dishList;
    }
}
