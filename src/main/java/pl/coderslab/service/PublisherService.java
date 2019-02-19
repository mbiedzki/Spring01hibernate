package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;

import java.util.List;

@Service
@Transactional
public class PublisherService {
    @Autowired
    private PublisherDao publisherDao;

    public void savePublisherService(Publisher entity) {
        publisherDao.savePublisher(entity);
    }

    public Publisher findPublisherByIdService(Long id) {
        return publisherDao.findById(id);
    }

    public void editPublisherService(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public void deletePublisherService(Long id) {
        Publisher entity = findPublisherByIdService(id);
        publisherDao.delete(entity);
    }

    public List<Publisher> readAllPublisherService() {
        List<Publisher> publisherList = publisherDao.findAll();
        return publisherList;
    }
}
