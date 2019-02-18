package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void saveBookService(Book entity) {
        bookDao.saveBook(entity);
    }

    public Book findByIdService(Long id) {
        return bookDao.findById(id);
    }

    public void editBookService(Long id) {
        Book book = findByIdService(id);
        String oldTitle = book.getTitle();
        String newTitle = "edited"+oldTitle;
        book.setTitle(newTitle);
        bookDao.update(book);
    }

    public void deleteBookService(Long id) {
        Book entity = findByIdService(id);
        bookDao.delete(entity);
    }

    public List<Book> readAllBookService() {
        List<Book> bookList = bookDao.findAll();
        return bookList;
    }

}
