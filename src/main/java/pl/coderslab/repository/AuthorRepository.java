package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAuthorByEmail(String string);

    List<Author> findAuthorByPesel(String string);

    List<Author> findAuthorByLastNameStartingWith(String string);

}
