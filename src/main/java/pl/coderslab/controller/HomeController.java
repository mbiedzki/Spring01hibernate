package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.CategoryService;
import pl.coderslab.service.PublisherService;

@Controller
public class HomeController {

    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(path = "/", produces = "text/html; charset=UTF-8")
    public String home(Model model) {

        model.addAttribute("numberOfBooks", bookService.countBooks());
        model.addAttribute("numberOfAuthors", authorService.countAuthors());
        model.addAttribute("numberOfPublishers", publisherService.countPublishers());
        model.addAttribute("numberOfCategories", categoryService.countCategories());

        return "home";
    }


}




