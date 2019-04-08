package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT count(categories.id) from Category categories")
    Long countCategories();


}
