package ua.i.giggs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.i.giggs.model.Worker;
import ua.i.giggs.service.WorkerService;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    private WorkerService workerService;

    @Autowired(required = true)
    @Qualifier(value = "workerService")
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping(value = "worker", method = RequestMethod.POST)
    public String listWorker(Model model){
        model.addAttribute("worker", new Worker());
        model.addAttribute("listWorker", this.workerService.listWorker());

        return "worker";
    }

    @RequestMapping(value = "/worker/add", method = RequestMethod.GET)
    public String addWorker(@ModelAttribute("worker") Worker worker){
        if(worker.getWorkerid() == 0){
            this.workerService.addWorker(worker);
        }else {
            this.workerService.updateWorker(worker);
        }

        return "redirect:/worker";
    }

    @RequestMapping("/workerremove/{id}")
    public String removeWorker(@PathVariable("id") int id){
        this.workerService.removeWorker(id);

        return "redirect:/worker";
    }

    @RequestMapping("workeredit/{id}")
    public String editWorker(@PathVariable("id") int id, Model model){
        model.addAttribute("worker", this.workerService.getWorkerById(id));
        model.addAttribute("listWorker", this.workerService.listWorker());

        return "worker";
    }

    @RequestMapping("workerdata/{id}")
    public String workerData(@PathVariable("id") int id, Model model){
        model.addAttribute("worker", this.workerService.getWorkerById(id));

        return "workerdata";
    }
}
