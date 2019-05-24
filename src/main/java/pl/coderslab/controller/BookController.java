package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.BookRepo;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.CategoryService;
import pl.coderslab.service.PublisherService;
import pl.coderslab.validator.ValidationBook;
import pl.coderslab.validator.ValidationProposition;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path = "/books", produces = "text/html; charset=UTF-8")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;


    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.readAllPublisherService();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorService.readAllAuthorService();
    }

    @ModelAttribute("categories")
    public List<Category> getCategory() {
        return categoryService.readAllCategoryService();
    }

    //add

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping(path = "/add")
    public String add(@Validated({ValidationBook.class}) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/add";
        }

        bookService.saveBookService(book);
        return "redirect:/books/all";
    }


    //edit
    @GetMapping(path = "/edit/{id}")
    public String forEdit(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findByIdService(id));
        return "books/add";
    }

    @PostMapping(path = "/edit/{id}")
    public String save(@Validated({ValidationBook.class}) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/add";
        }
        bookService.editBookService(book);
        return "redirect:/books/all";
    }

    //get by id
    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable Long id) {
        Book book = bookService.findByIdService(id);
        return "Wybrałes ksiażke :" + book;

    }

    //delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {

    //just for test app we do not allow to delete book with id <9 to keep minimum test database intact
    //several times somebody deleted all books
        if(id < 9) {
            model.addAttribute("sorry", true);
            model.addAttribute("books", bookService.readAllBookService());
            return "books/all";
        }
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

    //set rating
    @GetMapping(path = "/setRating")
    public String setRating(@RequestParam Double rating) {
        bookService.setRating(rating);
        return "redirect: /books/all";

    }


}
