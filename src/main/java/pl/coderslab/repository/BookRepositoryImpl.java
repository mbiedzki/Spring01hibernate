package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepo {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void setRating(Double rating) {
        Query q = entityManager.createQuery("update Book book set book.rating= :rating");
        q.setParameter("rating", rating).executeUpdate();

    }

}
