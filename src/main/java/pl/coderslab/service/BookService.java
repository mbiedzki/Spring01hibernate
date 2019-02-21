package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class BookService {
    /*@Autowired
    private BookDao bookDao;*/
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void saveBookService(Book entity) {
        bookRepository.save(entity);
    }

    public Book findByIdService(Long id) {
        return bookRepository.findOne(id);
    }

    public void editBookService(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookService(Long id) {
        bookRepository.delete(id);
    }

    public List<Book> readAllBookService() {
        //return bookRepository.findFirstByCategoryOrderByTitle(categoryRepository.findOne(1L));
        return bookRepository.findAll();
    }

}
