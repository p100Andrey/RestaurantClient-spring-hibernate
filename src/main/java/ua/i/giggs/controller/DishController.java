package ua.i.giggs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.i.giggs.model.Dish;
import ua.i.giggs.model.Worker;
import ua.i.giggs.service.DishService;
import ua.i.giggs.service.WorkerService;

@Controller
public class DishController {
    private WorkerService workerService;
    private DishService dishService;

    @Autowired(required = true)
//    @Qualifier(value = "dishService")
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @Autowired(required = true)
    @Qualifier(value = "workerService")
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping(value = "restaurantmap", method = RequestMethod.GET)
    public String restaurantmap() {
        return "restaurantmap";
    }

    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public String contacts() {
        return "contacts";
    }

    @RequestMapping(value = "worker", method = RequestMethod.GET)
    public String worker() {
        return "worker";
    }

    @RequestMapping(value = "worker", method = RequestMethod.GET)
    public String listWorker(Model model){
        model.addAttribute("worker", new Worker());
        model.addAttribute("listWorker", this.workerService.listWorker());

        return "worker";
    }

    @RequestMapping(value = "dish", method = RequestMethod.GET)
    public String listDish(Model model){
        model.addAttribute("dish", new Dish());
        model.addAttribute("listDish", this.dishService.listDish());

        return "dish";
    }

    @RequestMapping(value = "/dish/add", method = RequestMethod.POST)
    public String addDish(@ModelAttribute("dish") Dish dish){
        if(dish.getDishid() == 0){
            this.dishService.addDish(dish);
        }else {
            this.dishService.updateDish(dish);
        }

        return "redirect:/dish";
    }

    @RequestMapping("/dishremove/{id}")
    public String removeDish(@PathVariable("id") int id){
        this.dishService.removeDish(id);

        return "redirect:/dish";
    }

    @RequestMapping("dishedit/{id}")
    public String editDish(@PathVariable("id") int id, Model model){
        model.addAttribute("dish", this.dishService.getDishById(id));
        model.addAttribute("listDish", this.dishService.listDish());

        return "dish";
    }

    @RequestMapping("dishdata/{id}")
    public String dishData(@PathVariable("dishid") int id, Model model){
        model.addAttribute("dish", this.dishService.getDishById(id));

        return "dishdata";
    }
}