package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.model.*;

import java.util.List;


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

    @RequestMapping(path = "/readAllPerson")
    @ResponseBody
    public String readAllPerson() {
        List<Person> personList = personDao.findAll();
        return "Znaleziono osoby : " + personList;
    }

    @GetMapping(path = "/add")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "persons/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String save(@ModelAttribute Person person) {
        personDao.save(person);
        return "Zapis osoby : " + person;
    }

}
