package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(path="/validations", produces = "text/html; charset=UTF-8")

public class ValidationController {
    @Autowired
    private Validator validator;

    @RequestMapping("/validation")
    public String validate(Model model) {

        Publisher publisher = new Publisher();
        //publisher.setName("");
        Set<ConstraintViolation<Publisher>> validate = validator.validate(publisher);

        model.addAttribute("validate", validate);
        return "validations/validation";
    }


}
