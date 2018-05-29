package com.example.event_management.Controller;

import com.example.event_management.Model.Category;
import com.example.event_management.Service.CategoryService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(categoryService.getById(id));

    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity getByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(categoryService.getByName(name));

    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(categoryService.deleteAll());

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(categoryService.deleteById(id));

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postNewCity(@RequestBody Category category) throws ServiceException {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity putChangeCity(@RequestBody Category category) throws ServiceException {
        return ResponseEntity.ok(categoryService.putCategory(category));
    }

}