package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.BookRepository;

import java.util.List;

@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public void saveAuthorService(Author entity) {
        authorRepository.save(entity);
    }

    public Author findAuthorByIdService(Long id) {
        return authorRepository.findOne(id);
    }

    public void editAuthorService(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthorService(Long id) {
        authorRepository.delete(id);
    }

    public Long countAuthors() {
        return authorRepository.countAuthors();
    }

    public List<Author> readAllAuthorService() {
        return authorRepository.findAll();
        //return authorRepository.findAuthorByLastNameStartingWith("Le");
    }

    public boolean noBooksWithAuthor(Long id) {
        Author author = authorRepository.findOne(id);
        List<Book> books = bookRepository.findBookByAuthors(author);
        if (!books.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }


}
