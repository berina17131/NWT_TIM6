package com.example.event_management.Controller;

import com.example.event_management.Model.Category;
import com.example.event_management.Model.Place;
import com.example.event_management.Repository.CategoryRepository;
import com.example.event_management.Service.CategoryService;
import com.example.event_management.Service.EventService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity getAll() throws ServiceException {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(categoryService.getById(id));

    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public ResponseEntity getByName(@PathVariable("name") String name) throws ServiceException {
        return ResponseEntity.ok(categoryService.getByName(name));

    }

    @RequestMapping(value="/delete/all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() throws ServiceException {
        return ResponseEntity.ok(categoryService.deleteAll());

    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") String id) throws ServiceException {
        return ResponseEntity.ok(categoryService.deleteById(id));

    }

    @RequestMapping(value={"/create/{title}", "/create/{title}/{description}"}, method = RequestMethod.POST)
    public ResponseEntity postByName(@PathVariable("title") String title, @PathVariable("description") Optional<String> description) throws ServiceException {
        return ResponseEntity.ok(categoryService.postByName(title, description));
    }

    @RequestMapping(value={"/id/{id}/newName/{newName}", "/id/{id}/newName/{newName}/description/{description}"}, method = RequestMethod.PUT)
    public ResponseEntity putById(@PathVariable("id") String id, @PathVariable("newName") String newName, @PathVariable("description") Optional<String> description) throws ServiceException {
        return ResponseEntity.ok(categoryService.putById(id, newName, description));
    }

    @RequestMapping(value={"/oldName/{oldName}/newName/{newName}", "/oldName/{oldName}/newName/{newName}/description/{description}"}, method = RequestMethod.PUT)
    public ResponseEntity putByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName, @PathVariable("description") Optional<String> description) throws ServiceException {
        return ResponseEntity.ok(categoryService.putByName(oldName, newName, description));
    }
}