package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Book;
import pl.coderslab.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(Person person) {
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }

    public List<Person> findAll() {
        Query query = entityManager.createQuery("SELECT person FROM Person person");
        List<Person> personList  = query.getResultList();
        return personList;
    }
}
