package ua.i.giggs.service;

import ua.i.giggs.model.Worker;
import java.util.List;

public interface WorkerService {
    public void addWorker(Worker worker);

    public void updateWorker(Worker worker);

    public void removeWorker(int id);

    public Worker getWorkerById(int id);

    public List<Worker> listWorker();
}