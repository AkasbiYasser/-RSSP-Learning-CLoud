package com.PfaGroup5.ZLearning.controller;

import com.PfaGroup5.ZLearning.model.Category;
import com.PfaGroup5.ZLearning.model.Course;
import com.PfaGroup5.ZLearning.model.Instructor;
import com.PfaGroup5.ZLearning.model.Student;
import com.PfaGroup5.ZLearning.service.CategoryService;
import com.PfaGroup5.ZLearning.service.CourseService;
import com.PfaGroup5.ZLearning.service.InstructorService;
import com.PfaGroup5.ZLearning.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminDashBoardController {

    private final InstructorService instructorService;
    private final StudentService studentService;
    private final CourseService courseService;
    private final CategoryService categoryService;

    public AdminDashBoardController(InstructorService instructorService, StudentService studentService, CategoryService categoryService, CourseService courseService) {
        this.instructorService = instructorService;
        this.studentService = studentService;
        this.courseService = courseService;
        this.categoryService = categoryService;
    }

    // get the number of instructors, students, courses and categories
    @GetMapping("/instructors/nr")
    public int getInstructorsNr() {
        return instructorService.getInstructorsNr();
    }

    @GetMapping("/students/nr")
    public int getStudentsNr() {
        return studentService.getStudentsNr();
    }

    @GetMapping("/courses/nr")
    public int getCoursesNr() {
        return courseService.getCoursesNr();
    }

    @GetMapping("/categories/nr")
    public int getCategoriesNr() {

        return categoryService.getCategoriesNr();
    }

    // add operations for courses, categories, students and instructors

    @PostMapping("/instructors")
    public ResponseEntity addInstructor(@RequestBody Instructor instructor, @RequestParam(value = "image", required = false) MultipartFile file) {
        instructorService.addInstructor(instructor, file);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/courses")
    public ResponseEntity addCertif(@RequestBody Course course) {
        courseService.addCertif(course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/categories")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {

        return  ResponseEntity.ok(categoryService.addCategory(category));
    }
    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok().build();
    }


    // get all operations for courses, categories, students and instructors

    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/courses")
    public List<Course> getAllCertif() {
        return courseService.getAllCertif();
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // get operations for courses, categories, students and instructors by id

    @GetMapping("/instructors/{id}")
    public Instructor getInstructorById(@PathVariable String id) {
        return instructorService.getInstructorById(id);
    }

    @GetMapping("/courses/{id}")
    public Course getCertifById(@PathVariable String id) {
        return courseService.getCertifById(id);
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }


    // update operations for courses, categories, students and instructors

    @PutMapping("/instructors/{id}")
    public ResponseEntity updateInstructor(@PathVariable String id,@RequestBody Instructor instructor, @RequestParam(value = "image", required = false) MultipartFile file) {
        instructorService.updateInstructor( id, instructor, file);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity updateCertif(@PathVariable String id, @RequestBody Course course) {
        courseService.updateCertif(id, course);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity updateCategory(@PathVariable String id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok().build();
    }


    // delete operations for courses, categories, students and instructors

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity deleteInstructor(@PathVariable String id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity deleteCertif(@PathVariable String id) {
        courseService.deleteCertif(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
