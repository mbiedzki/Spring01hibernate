package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.CategoryService;
import pl.coderslab.validator.ValidationProposition;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/categories", produces = "text/html; charset=UTF-8")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> getCategory() {
        return categoryService.readAllCategoryService();
    }

    //add

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "categories/addEdit";
    }

    @PostMapping(path = "/add")
    public String add(@Valid Category category, BindingResult result) {

        if (result.hasErrors()) {
            return "categories/addEdit";
        }

        categoryService.saveCategoryService(category);
        return "redirect:/categories/all";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryService.findByIdService(id));
        return "categories/addEdit";
    }

    @PostMapping(path = "/edit/{id}")
    public String edit(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categories/addEdit";
        }
        categoryService.editCategoryService(category);
        return "redirect:/categories/all";
    }

    //delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (categoryService.noBooksInCategory(id)) {
            categoryService.deleteCategoryService(id);
            return "redirect:/categories/all";
        } else {
            model.addAttribute("deleteError", true);
            return "/categories/all";
        }
    }

    @RequestMapping("/all")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryService.readAllCategoryService());
        return "categories/all";

    }
}
