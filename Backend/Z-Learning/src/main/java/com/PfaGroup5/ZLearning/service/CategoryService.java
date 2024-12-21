package com.PfaGroup5.ZLearning.service;

import com.PfaGroup5.ZLearning.model.Category;
import com.PfaGroup5.ZLearning.model.Course;
import com.PfaGroup5.ZLearning.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;
    private final CourseService courseService;

    public CategoryService(CategoryRepo categoryRepo , CourseService CourseService) {
        this.categoryRepo = categoryRepo;
        this.courseService = CourseService;
    }

    public Category findByName(String name) {
        return categoryRepo.findByName(name);
    }

    public void EditIdList(String action, String categotyName ,String certifIf){
        if (action.equals("add")){
            Category category = categoryRepo.findByName(categotyName);
            category.getCertifId().add(certifIf);
            categoryRepo.save(category);
        }else if (action.equals("remove")){
            Category category = categoryRepo.findByName(categotyName);
            category.getCertifId().remove(certifIf);
            categoryRepo.save(category);
        }
    }



    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public ArrayList<Course> getAllCertifsByCategory(String id){
        Category categoryy = categoryRepo.findById(id).orElse(null);
        if (categoryy != null){
            ArrayList<String> certifs = new ArrayList<>();
            certifs = categoryy.getCertifId();
            ArrayList<Course> courseList = new ArrayList<>();
            return courseList = courseService.getAllCertifsByIds(certifs);
        }
        return null;
    }

    public Category addCategory(Category category) {

        Category categories = categoryRepo.findByName(category.getName());
        if (categories != null) {
            return null;
        }
        categoryRepo.insert(category);
        return category;
    }

    public int getCategoriesNr() {
        return categoryRepo.findAll().size();
    }

    public Category getCategoryById(String id){
        return categoryRepo.findById(id).orElse(null);
    }

    public void updateCategory(String id,Category category) {
        Category category1 = categoryRepo.findById(id).orElse(null);
        if (category1 == null) {
            throw new RuntimeException("Category not found");
        }

        category1.setName(category.getName());
        categoryRepo.save(category1);
    }

    public void deleteCategory(String id) {
        Category category = categoryRepo.findById(id).orElse(null);
        if (category == null) {
            throw new RuntimeException("Category not found");
        }

        categoryRepo.delete(category);
    }
}
