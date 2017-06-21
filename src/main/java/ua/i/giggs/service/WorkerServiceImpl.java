package ua.i.giggs.service;

import org.springframework.transaction.annotation.Transactional;
import ua.i.giggs.dao.WorkerDao;
import ua.i.giggs.model.Worker;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    private WorkerDao workerDao;

    public void setWorkerDao(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @Override
    @Transactional
    public void addWorker(Worker worker) {
        this.workerDao.addWorker(worker);
    }

    @Override
    @Transactional
    public void updateWorker(Worker worker) {
        this.workerDao.updateWorker(worker);
    }

    @Override
    @Transactional
    public void removeWorker(int id) {
        this.workerDao.removeWorker(id);
    }

    @Override
    @Transactional
    public Worker getWorkerById(int id) {
        return this.workerDao.getWorkerById(id);
    }

    @Override
    @Transactional
    public List<Worker> listWorker() {
        return this.workerDao.listWorker();
    }
}
