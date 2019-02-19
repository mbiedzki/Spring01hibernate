package pl.coderslab.converter;

import org.hibernate.engine.config.spi.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.PublisherService;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorService authorService;

    @Override
    public Author convert(String s) {
        return authorService.findAuthorByIdService(Long.parseLong(s));
    }
}
