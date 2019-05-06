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
import pl.coderslab.repository.PublisherRepository;

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
    @Autowired
    private PublisherRepository publisherRepository;

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

    public void setRating(Double rating) {
        bookRepository.setRating(rating);
    }

    public Long countBooks() {
        return bookRepository.countBooks();
    }

    public List<Book> readAllBookService() {
        return bookRepository.findAll();

        //testujemy metody z BookRepository
        //return bookRepository.findFirstByCategoryOrderByTitle(categoryRepository.findOne(1L));

        //własne query zdefiniowane w BookRepository
        //return bookRepository.findBookByCategoryIdByQuery(categoryRepository.findOne(1L));

        //testujemy rating range
        //return bookRepository.findBookByRatingRange();

        //testujemy by publisher
        //return bookRepository.findBookByPublisherByQuery(publisherRepository.findOne(1L));

        //testujemy by category sorted by title first
        //return bookRepository.findFirstBookByCategorySorted(1L);
    }

}
