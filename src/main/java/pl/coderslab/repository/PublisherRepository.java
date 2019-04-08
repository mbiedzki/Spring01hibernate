package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    List<Publisher> findPublisherByNip(String string);

    List<Publisher> findPublisherByRegon(String string);

    @Query("SELECT count(publishers.id) from Publisher publishers")
    Long countPublishers();

}
