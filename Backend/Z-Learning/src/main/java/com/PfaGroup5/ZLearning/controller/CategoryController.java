package com.PfaGroup5.ZLearning.controller;

import com.PfaGroup5.ZLearning.model.Category;
import com.PfaGroup5.ZLearning.model.Course;
import com.PfaGroup5.ZLearning.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Api/Category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }




    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {

        return  ResponseEntity.ok(categoryService.addCategory(category));
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ArrayList<Course>> getAllCertifsByCategory(@PathVariable String id) {
        if (categoryService.getAllCertifsByCategory(id) != null) {
            return ResponseEntity.ok(categoryService.getAllCertifsByCategory(id));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


}
