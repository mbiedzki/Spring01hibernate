package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {
    @Autowired
    private Validator validator;

    @RequestMapping("/validate")
    @ResponseBody
    public String validate() {
        Book book = new Book();
        book.setTitle("Tytuł książki");
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        if(!validate.isEmpty()) {
            for (ConstraintViolation<Book> validationElement : validate) {
                System.out.println(validationElement.getPropertyPath() + " : " +validationElement.getMessage());
            }
        } else {
            System.out.println("nie ma błędów");
        }
        return "validate";
    }


}
