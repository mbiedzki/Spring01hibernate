package pl.coderslab.model;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 75)
    private String author;

    @Column(nullable = false, precision = 4, scale = 2)
    private Double rating;

    @Column(nullable = false, length = 125)
    private String publisher;

    @Column(length = 1000)
    private String description;
}
