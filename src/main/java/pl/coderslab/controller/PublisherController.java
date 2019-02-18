package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Controller
@RequestMapping(path="/publishers", produces = "text/html; charset=UTF-8")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @RequestMapping(path = "/createPublisher")
    @ResponseBody
    public String createPublisher() {
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

    }
}
