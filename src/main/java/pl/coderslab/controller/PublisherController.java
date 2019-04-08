package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.PublisherService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/publishers", produces = "text/html; charset=UTF-8")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @ModelAttribute("publishers")
    public List<Publisher> getAuthor() {
        return publisherService.readAllPublisherService();
    }

    //add
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publishers/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "publishers/add";
        }
        publisherService.savePublisherService(publisher);
        return "redirect:/publishers/all";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("publisher", publisherService.findPublisherByIdService(id));
        return "publishers/add";
    }

    @PostMapping(path = "/edit/{id}")
    public String edit(@Valid Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "publishers/add";
        }
        publisherService.editPublisherService(publisher);
        return "redirect:/publishers/all";
    }

    //delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (publisherService.noBooksWithPublisher(id)) {
            publisherService.deletePublisherService(id);
            return "redirect:/publishers/all";
        } else {
            model.addAttribute("deleteError", true);
            return "publishers/all";
        }

    }

    @RequestMapping("/all")
    public String getAllPublishers(Model model) {
        model.addAttribute("publishers", publisherService.readAllPublisherService());
        return "publishers/all";

    }

}
