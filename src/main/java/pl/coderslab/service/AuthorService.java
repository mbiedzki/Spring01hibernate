package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Person;

import java.util.List;

@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;

    public void saveAuthorService(Author entity) {
        authorDao.saveAuthor(entity);
    }

    public Author findAuthorByIdService(Long id) {
        return authorDao.findById(id);
    }

    public void editAuthorService(Author author) {
        authorDao.update(author);
    }

    public void deleteAuthorService(Long id) {
        Author entity = findAuthorByIdService(id);
        authorDao.delete(entity);
    }

    public List<Author> readAllAuthorService() {
        List<Author> authorList = authorDao.findAll();
        return authorList;
    }
}
