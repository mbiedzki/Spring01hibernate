package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void saveBookService(Book entity) {
        bookDao.saveBook(entity);
    }

    public Book findByIdService(Long id) {
        return bookDao.findById(id);
    }

    public void editBookService(Book book) {
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
