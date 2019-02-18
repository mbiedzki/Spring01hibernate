package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
