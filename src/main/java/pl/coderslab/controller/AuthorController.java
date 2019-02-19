package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Person;
import pl.coderslab.service.AuthorService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/authors", produces = "text/html; charset=UTF-8")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(path = "/createAuthor")
    @ResponseBody
    public String createAuthor() {
        List<Book> books = new ArrayList<>();
        Author author = new Author("Jan", "Kowalski");
        authorService.saveAuthorService(author);
        return "Utworzono autora : " + author;
    }

    //add
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "authors/add";
    }

    @PostMapping(path = "/add")
    public String add(@ModelAttribute Author author) {
        authorService.saveAuthorService(author);
        return "redirect:/authors/all";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorService.findAuthorByIdService(id));
        return "authors/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String edit(@ModelAttribute Author author) {
        authorService.editAuthorService(author);
        return "redirect:/authors/all";
    }

    //delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        authorService.deleteAuthorService(id);
        return "redirect:/authors/all";

    }


    /*@RequestMapping(path = "/changeAuthor/{id}")
    @ResponseBody
    public String changeAuthor(@PathVariable Long id) {
        Long display = id;
        authorService.editAuthorService(id);
        return "Autor został zedytowany : "+display;
    }*/

    @RequestMapping("/getAuthor/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id) {
        Author author = authorService.findAuthorByIdService(id);
        return "Wybrałes autora : "+author;

    }

    @RequestMapping("/deleteAuthor/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable Long id) {
        Long display = id;
        authorService.deleteAuthorService(id);
        return "Autor usunięty : "+display;

    }

    @RequestMapping("/all")
    public String getAllAuthor(Model model) {
        model.addAttribute("authors", authorService.readAllAuthorService());
        return "authors/all";

    }



}
