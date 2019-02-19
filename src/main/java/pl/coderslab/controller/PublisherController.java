package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Controller
@RequestMapping(path="/publishers", produces = "text/html; charset=UTF-8")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    //add
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publishers/add";
    }

    @PostMapping(path = "/add")
    public String add(@ModelAttribute Publisher publisher) {
        publisherService.savePublisherService(publisher);
        return "redirect:/publishers/all";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("publisher", publisherService.findPublisherByIdService(id));
        return "publishers/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String edit(@ModelAttribute Publisher publisher) {
        publisherService.editPublisherService(publisher);
        return "redirect:/publishers/all";
    }

    //delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        publisherService.deletePublisherService(id);
        return "redirect:/publishers/all";

    }

    @RequestMapping("/all")
    public String getAllPublishers(Model model) {
        model.addAttribute("publishers", publisherService.readAllPublisherService());
        return "publishers/all";

    }

    /*@RequestMapping(path = "/add")
    public String add() {
        Publisher publisher = new Publisher("Iskry");
        publisherService.savePublisherService(publisher);
        return "Utworzono wydawcę : " + publisher;
    }

    @RequestMapping(path = "/changePublisher/{id}")
    @ResponseBody
    public String changePublisher(@PathVariable Long id) {
        Long display = id;
        publisherService.editPublisherService(id);
        return "Wydawca został zedytowany : "+display;
    }

    @RequestMapping("/getPublisher/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable Long id) {
        Publisher publisher = publisherService.findPublisherByIdService(id);
        return "Wybrałes wydawcę : "+publisher;

    }
    @RequestMapping("/deletePublisher/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable Long id) {
        Long display = id;
        publisherService.deletePublisherService(id);
        return "Wydawca usunięty : "+display;

    }

    @RequestMapping("/getAllPublisher")
    @ResponseBody
    public String getAllPublisher() {
        List<Publisher> publisherList = publisherService.readAllPublisherService();
        return "Wszyscy wydawcy : " + publisherList;

    }*/
}
