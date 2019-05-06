package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.validator.ValidationProposition;

@Controller
@RequestMapping(path = "/propositions", produces = "text/html; charset=UTF-8")
public class PropositionController {

    @Autowired
    private BookService bookService;

    //add

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "propositions/add";
    }

    @PostMapping(path = "/add")
    public String add(@Validated({ValidationProposition.class}) Book book, BindingResult result) {

        if (result.hasErrors()) {
            return "propositions/add";
        }

        bookService.saveBookService(book);
        return "redirect:/books/all";
    }


}
