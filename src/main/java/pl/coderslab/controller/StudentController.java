package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Person;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path="/students", produces = "text/html; charset=UTF-8")
public class StudentController {
    @Autowired Student student;

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("fishing", "tennis", "arts");
    }

    @ModelAttribute("skills")
    public List<String> skills() {
        return Arrays.asList("Java", "C+", "Python");
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "students/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String save(@ModelAttribute Student student) {
        return "Zapis osoby : " + student;
    }

}
