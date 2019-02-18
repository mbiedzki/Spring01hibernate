package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.service.AuthorService;

@Controller
@RequestMapping(path="/authors", produces = "text/html; charset=UTF-8")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(path = "/createAuthor")
    @ResponseBody
    public String createAuthor() {
        Author author = new Author("Jan", "Kowalski");
        authorService.saveAuthorService(author);
        return "Utworzono autora : " + author;
    }

    @RequestMapping(path = "/changeAuthor/{id}")
    @ResponseBody
    public String changeAuthor(@PathVariable Long id) {
        Long display = id;
        authorService.editAuthorService(id);
        return "Autor został zedytowany : "+display;
    }

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
}
