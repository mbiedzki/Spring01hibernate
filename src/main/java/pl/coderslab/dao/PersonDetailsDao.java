package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Person;
import pl.coderslab.model.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }

    public PersonDetails findById(Long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void update(PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }

    public void delete(PersonDetails personDetails) {
        entityManager.remove(entityManager.contains(personDetails) ?
                personDetails : entityManager.merge(personDetails));
    }
}
