package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank
    @Size(min = 5, max = 100)
    private String title;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @NotEmpty
    private List<Author> authors = new ArrayList<>();

    @Column(nullable = false, precision = 4, scale = 2)
    @NotNull(message="rating nie może być pusty")
    @Min(1)
    @Max(10)
    private Double rating;

    @ManyToOne()
    @NotNull
    private Publisher publisher;

    @Column(length = 600)
    @Size(max = 600)
    private String description;

    @Min(1)
    private int pages;

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

    public List<Author> getAuthor() {
        return authors;
    }

    public void setAuthor(List<Author> authors) {
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
