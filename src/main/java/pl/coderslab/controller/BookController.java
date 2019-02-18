package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.BookService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path="/books", produces = "text/html; charset=UTF-8")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/createBook")
    @ResponseBody
    public String createBook() {
        Publisher publisher = new Publisher("Helios");
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Jan", "Kowalski"));
        Book book = new Book("Java", authors, 9.20, publisher, "fajna książka");
        bookService.saveBookService(book);
        return "Utworzono książkę : " + book;
    }

    @RequestMapping(path = "/changeBook/{id}")
    @ResponseBody
    public String changeBook(@PathVariable Long id) {
        Long display = id;
        bookService.editBookService(id);
        return "Książka została zedytowana : "+display;
    }

    @RequestMapping("/getBook/{id}")
    @ResponseBody
    public String getBook(@PathVariable Long id) {
        Book book = bookService.findByIdService(id);
        return "Wybrałes ksiażke :"+book;

    }
    @RequestMapping("/deleteBook/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        Long display = id;
        bookService.deleteBookService(id);
        return "Książka usunięta : "+display;

    }

    @RequestMapping("/getAllBook")
    @ResponseBody
    public String getAllBook() {
        List<Book> bookList = bookService.readAllBookService();
        return "Wszystkie książki : " + bookList;

    }

}
