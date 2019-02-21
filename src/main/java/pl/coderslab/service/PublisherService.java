package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.PublisherRepository;

import java.util.List;

@Service
@Transactional
public class PublisherService {
    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private PublisherRepository publisherRepository;

    public void savePublisherService(Publisher entity) {
        publisherRepository.save(entity);
    }

    public Publisher findPublisherByIdService(Long id) {
        return publisherRepository.findOne(id);
    }

    public void editPublisherService(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deletePublisherService(Long id) {
        publisherRepository.delete(id);
    }

    public List<Publisher> readAllPublisherService() {
        return publisherRepository.findAll();
        //return publisherRepository.findPublisherByRegon("280034594");
    }
}
