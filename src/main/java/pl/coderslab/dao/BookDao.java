package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class BookDao {
    private Book book;

    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("SELECT book FROM Book book");
        List<Book> bookList = query.getResultList();
        return bookList;
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("SELECT book FROM Book book WHERE rating >:rating");
        query.setParameter("rating", rating);
        List<Book> bookList = query.getResultList();
        return bookList;
    }


}
