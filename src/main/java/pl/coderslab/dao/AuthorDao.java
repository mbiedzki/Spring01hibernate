package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;
    public void saveAuthor(Author entity) {
        entityManager.persist(entity);
    }

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author entity) {
        entityManager.merge(entity);
    }

    public void delete(Author entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }
}
