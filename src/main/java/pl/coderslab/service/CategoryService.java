package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category findByIdService(Long id) {
        return categoryRepository.findOne(id);
    }

    public void editCategoryService(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategoryService(Long id) {
        categoryRepository.delete(id);
    }

    public List<Category> readAllCategoryervice() {
        return categoryRepository.findAll();
    }




}
