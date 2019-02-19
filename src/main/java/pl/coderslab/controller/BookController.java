package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path="/books", produces = "text/html; charset=UTF-8")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.readAllPublisherService();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorService.readAllAuthorService();
    }

    //add
    @PostMapping(path = "/add")
    public String add(@ModelAttribute Book book) {
        bookService.saveBookService(book);
        return "redirect:/books/all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }


    //edit
    @GetMapping(path="/edit/{id}")
    public String forEdit(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findByIdService(id));
        return "books/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String save(@ModelAttribute Book book) {
        bookService.editBookService(book);
        return "redirect:/books/all";
    }

    //get by id
    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable Long id) {
        Book book = bookService.findByIdService(id);
        return "Wybrałes ksiażke :"+book;

    }

    //delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.deleteBookService(id);
        return "redirect:/books/all";

    }

    /*@RequestMapping("/getAll")
    @ResponseBody
    public String getAll() {
        List<Book> bookList = bookService.readAllBookService();
        return "Wszystkie książki : " + bookList;

    }*/

    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("books", bookService.readAllBookService());
        return "books/all";
    }



}
