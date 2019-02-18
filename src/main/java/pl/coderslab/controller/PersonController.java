package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.model.*;


@Controller
@RequestMapping(path="/persons", produces = "text/html; charset=UTF-8")
public class PersonController {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private PersonDetailsDao personDetailsDao;

    @RequestMapping(path = "/createPerson")
    @ResponseBody
    public String createPerson() {
        PersonDetails personDetails =  new PersonDetails("Michal", "Biedzki", 25, "Długa", "Warszawa");
        Person person = new Person("mb", "aaaaaa", "mb@wp.pl", personDetails);
        personDao.save(person);
        return "Utworzono osobę : " + person;
    }

    @RequestMapping(path = "/readPerson/{id}")
    @ResponseBody
    public String readPerson(@PathVariable Long id) {
        Person person = personDao.findById(id);
        return "Znaleziono osobę : " + person;
    }

    @RequestMapping(path = "/updatePerson/{id}")
    @ResponseBody
    public String updatePerson(@PathVariable Long id) {

        Person person = personDao.findById(id);
        person.setEmail("updated email");
        PersonDetails personDetails = person.getDetails();
        personDetails.setCity("updated City");
        person.setDetails(personDetails);
        personDao.update(person);

        return "Zaktualizowano osobę : " + person;
    }

    @RequestMapping(path = "/deletePerson/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable Long id) {
        Person person = personDao.findById(id);
        personDao.delete(person);
        return "Usunięto osobę : " + person;
    }

}
