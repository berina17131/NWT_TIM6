package com.example.event_management.Controller;

import com.example.event_management.Model.Category;
import com.example.event_management.Model.Place;
import com.example.event_management.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Category getById(@PathVariable("id") String id) {
        Optional categoryHelp = categoryRepository.findById(Integer.parseInt(id));
        Category category = (Category) categoryHelp.get();

        return category;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteAll() {
        categoryRepository.deleteAll();

        return "All categories deleted";
    }

    @RequestMapping(value="/id/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        categoryRepository.deleteById(Integer.parseInt(id));

        return "Category with id=" + id + " deleted";
    }

}