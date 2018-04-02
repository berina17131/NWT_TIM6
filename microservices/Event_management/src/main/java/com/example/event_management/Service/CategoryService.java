package com.example.event_management.Service;


import com.example.event_management.Model.Category;
import com.example.event_management.Repository.CategoryRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository  categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getAll() throws ServiceException {
        try {
            return categoryRepository.findAll();
        }catch (Exception e) {
            throw new ServiceException("Cannot fetch all categories.");
        }
    }

    public Category getById(String id) throws ServiceException {
        try {
            Optional categoryHelp = categoryRepository.findById(Integer.parseInt(id));
            Category category = (Category) categoryHelp.get();

            return category;
        }catch (Exception e) {
            throw new ServiceException("Cannot find category with id={" + id + "}");
        }
    }

    public Category getByName(String title) throws ServiceException {
        try {
            for (Category category : categoryRepository.findAll()) {
                if (category.getName().equals(title))
                    return category;
            }
            return null;
        }catch (Exception e) {
            throw new ServiceException("Cannot find place with title={" + title+ "}");
        }
    }

    public String deleteAll() throws ServiceException {
        try {
            categoryRepository.deleteAll();
            return "All categories deleted";

        }catch(Exception e) {
            throw new ServiceException("Cannon delete all categories");
        }

    }

    public String deleteById(String id) throws ServiceException {
        try {
            categoryRepository.deleteById(Integer.parseInt(id));
            return "category with id=" + id + " deleted";

        }catch(Exception e) {
            throw new ServiceException("Cannot delete place with id={" + id + "}");
        }

    }

    public String postByName(String name, Optional<String> description) throws ServiceException {
        try {
            Category category;
            if (description.isPresent()) category = new Category(name, description.get());
            else category = new Category(name, "");
            categoryRepository.save(category);

            return "Category with title " + name + " saved successfully";
        }catch (Exception e) {
            throw new ServiceException("Cannot save place with title={" + name + "}");
        }
    }

    public String putById(String id, String newName, Optional<String> description) throws ServiceException {
        try {
            Optional categoryHelp = categoryRepository.findById(Integer.parseInt(id));
            Category category = (Category) categoryHelp.get();
            String oldName = category.getName();
            category.setName(newName);
            if (description.isPresent()) category.setDescription(description.get());
            categoryRepository.save(category);

            return "Category with old name " + oldName + " saved successfully as " + newName;
        }catch (Exception e) {
            throw new ServiceException("Cannot change category.");
        }
    }

    public String putByName(String oldName, String newName, Optional<String> description) throws ServiceException {
        try {
            Category category = null;
            for (Category categoryHelp : categoryRepository.findAll()) {
                if (categoryHelp.getName().equals(oldName))
                    category = categoryHelp;
            }
            category.setName(newName);
            if (description.isPresent()) category.setDescription(description.get());
            categoryRepository.save(category);

            return "category with old name " + oldName + " saved successfully as " + newName;
        }catch (Exception e) {
            throw new ServiceException("Cannot change category.");
        }
    }


}
