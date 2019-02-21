package pl.coderslab.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.validator.ValidationBook;
import pl.coderslab.validator.ValidationProposition;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotBlank(groups={ValidationBook.class, ValidationProposition.class})
    @Size(min = 5, max = 100)
    private String title;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<>();

    @Column(precision = 4, scale = 2)
    @NotNull(groups={ValidationBook.class})
    @Min(1)
    @Max(10)
    @ColumnDefault("1")
    private Double rating;

    @ColumnDefault("0")
    @ManyToOne()
    private Publisher publisher;

    @Column(length = 600)
    @Size(max = 600)
    @NotBlank(groups={ValidationProposition.class})
    private String description;


    @Min(value = 1, groups = {ValidationBook.class})
    @ColumnDefault("1")
    private int pages;

    @ColumnDefault("0")
    private boolean proposition;

    @OneToOne
    private Category category;


    public Book(String title, List<Author> authors, Double rating, Publisher publisher, String description) {
        this.title = title;
        this.authors = authors;
        this.rating = rating;
        this.publisher = publisher;
        this.description = description;
    }

    public Book(String title, Double rating, Publisher publisher, String description) {
        this.title = title;
        this.rating = rating;
        this.publisher = publisher;
        this.description = description;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", publisher=" + publisher +
                ", description='" + description + '\'' +
                '}';
    }
}
