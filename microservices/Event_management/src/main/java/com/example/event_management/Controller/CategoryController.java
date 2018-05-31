package com.example.event_management.Controller;

import com.example.event_management.Model.Category;
import com.example.event_management.Service.CategoryService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(categoryService.getByName(name));
    }

    @DeleteMapping(value = "/delete/all")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(categoryService.deleteAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(categoryService.deleteById(id));
    }

    @PostMapping
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity postNewCategory(@RequestBody Category category) throws ServiceException {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @PutMapping
    @PreAuthorize("@tokenAuthenticationService.isAdmin()")
    public ResponseEntity putChangeCategory(@RequestBody Category category) throws ServiceException {
        return ResponseEntity.ok(categoryService.putCategory(category));
    }
}
