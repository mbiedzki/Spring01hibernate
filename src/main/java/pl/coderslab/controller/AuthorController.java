package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.service.AuthorService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/authors", produces = "text/html; charset=UTF-8")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @ModelAttribute("authors")
    public List<Author> getAuthor() {
        return authorService.readAllAuthorService();
    }

    //add
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "authors/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "authors/add";
        }

        authorService.saveAuthorService(author);
        return "redirect:/authors/all";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorService.findAuthorByIdService(id));
        return "authors/add";
    }

    @PostMapping(path = "/edit/{id}")
    public String edit(@Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "authors/add";
        }
        authorService.editAuthorService(author);
        return "redirect:/authors/all";
    }

    //delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (authorService.noBooksWithAuthor(id)) {
            authorService.deleteAuthorService(id);
            return "redirect:/authors/all";
        } else {
            model.addAttribute("deleteError", true);
            return "authors/all";
        }
    }

    @GetMapping("/all")
    public String getAllAuthor(Model model) {
        model.addAttribute("authors", authorService.readAllAuthorService());
        return "authors/all";

    }



}
