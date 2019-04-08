package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepo {

    List<Book> findBookByTitle(String title);

    List<Book> findBookByCategory(Category category);

    List<Book> findFirstByCategoryOrderByTitle(Category category);

    List<Book> findBookByCategoryId(Long id);

    List<Book> findBookByAuthors(Author author);

    List<Book> findBookByPublisher(Publisher publisher);

    List<Book> findBookByRating(Double rating);

    @Query("SELECT count(books.id) from Book books")
    Long countBooks();

    @Query("select book from Book book where book.title = ?1")
    List<Book> findBookByTitleByQuery(String title);

    @Query("select book from Book book where book.category = :category")
    List<Book> findBookByCategoryIdByQuery(@Param("category") Category category);

    @Query("select book from Book book where book.authors = :authors")
    List<Book> findBookByAuthorsIdByQuery(@Param("authors") Author author);

    //Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.
    @Query("select book from Book book where book.rating between 4 and 5")
    List<Book> findBookByRatingRange();

    @Query("select book from Book book where book.publisher = ?1 ")
    List<Book> findBookByPublisherByQuery(Publisher publisher);

    //Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
    @Query(value = "select * from books where category_id = ?1 order by title limit 1", nativeQuery = true)
    List<Book> findFirstBookByCategorySorted(Long id);


}
