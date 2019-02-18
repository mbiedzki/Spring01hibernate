package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;
    public void savePublisher(Publisher entity) {
        entityManager.persist(entity);
    }

    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher entity) {
        entityManager.merge(entity);
    }

    public void delete(Publisher entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }
}
