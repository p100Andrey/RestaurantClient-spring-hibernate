package ua.i.giggs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.i.giggs.model.Worker;

import java.util.List;

public class WorkerDaoImpl implements WorkerDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addWorker(Worker worker) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(worker);
    }

    @Override
    public void updateWorker(Worker worker) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(worker);
    }

    @Override
    public void removeWorker(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Worker worker = (Worker) session.load(Worker.class, new Integer(id));

        if (worker != null) {
            session.delete(worker);
        }
    }

    @Override
    public Worker getWorkerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Worker worker = (Worker) session.load(Worker.class, new Integer(id));

        return worker;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Worker> listWorker() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Worker> workerList = session.createQuery("from Worker").list();

        return workerList;
    }
}
