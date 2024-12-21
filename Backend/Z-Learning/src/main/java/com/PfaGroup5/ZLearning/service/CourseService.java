package com.PfaGroup5.ZLearning.service;

import com.PfaGroup5.ZLearning.model.Category;
import com.PfaGroup5.ZLearning.model.Course;
import com.PfaGroup5.ZLearning.repository.CategoryRepo;
import com.PfaGroup5.ZLearning.repository.CourseRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourseService {

    private final CourseRepo courseRepo;
    private final CategoryRepo categoryRepo;

    public CourseService(CourseRepo courseRepo, CategoryRepo categoryRepo) {
        this.courseRepo = courseRepo;
        this.categoryRepo = categoryRepo;
    }

    public void addCertif(Course course) {
        courseRepo.insert(course);
        Course savedCourse = courseRepo.findByTitle(course.getTitle()).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Certif by Name %s", course.getTitle())));


//        String categoryName = course.getCategoryName();
//        Category category = categoryRepo.findByName(categoryName);
//        if (category == null) {
//            // Create a new category
//            category = new Category();
//            category.setName(categoryName);
//            category.getCertifId().add(savedCourse.getId());
//            categoryRepo.insert(category);
//        } else {
//            // Add the certificate to the existing category
//            category.getCertifId().add(savedCourse.getId());
//            categoryRepo.save(category);
//        }




    }
    public List<Course> getAllCertif(){
        return courseRepo.findAll();
    }

    public Course getCertifByName(String name){
        return courseRepo.findByTitle(name).orElse(null);
    }

    public void updateCertif(String id, Course course) {
        // when updating a certificate, we need to update the category as well if the category title has changed
        // so we need to check if the category title has changed
        Course savedCourse = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Course by Id: %s", id)));

//        String oldCategoryName = savedCourse.getCategoryName();
//        String newCategoryName = course.getCategoryName();
//        Category cat = categoryRepo.findByName(newCategoryName);
//        if(cat == null) {
//            Category category = new Category();
//            category.setName(newCategoryName);
//            categoryRepo.insert(category);
//        }
//
//        if(!Objects.equals(oldCategoryName ,newCategoryName )){
//
//            Category cat1 = categoryRepo.findByName(oldCategoryName);
//            cat1.getCertifId().remove(savedCourse.getId());
//            categoryRepo.save(cat1);
//          //categoryRepo.findByName(newCategoryName).getCertifId().add(savedCertif.getId());
//            Category cat2 = categoryRepo.findByName(newCategoryName);
//            cat2.getCertifId().add(savedCourse.getId());
//            categoryRepo.save(cat2);
//
//        }

        savedCourse.setTitle(course.getTitle());
        savedCourse.setCategoryName(course.getCategoryName());
        savedCourse.setPrice(course.getPrice());
        savedCourse.setRating(course.getRating());
        savedCourse.setStartDate(course.getStartDate());
        savedCourse.setEndDate(course.getEndDate());
        savedCourse.setInstructorName(course.getInstructorName());
        savedCourse.setURL(course.getURL());
        savedCourse.setMainImagePath(course.getMainImagePath());
        savedCourse.setDescription(course.getDescription());
        savedCourse.setVideoUrl(course.getVideoUrl());
        savedCourse.setQuizUrl(course.getQuizUrl());

        courseRepo.save(savedCourse);
    }
    public void storeImage(String certifId, MultipartFile file) {
        Course course = courseRepo.findById(certifId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Certif by ID %s", certifId)));

        String originalFilename = file.getOriginalFilename();
        int lastDotIndex = originalFilename.lastIndexOf(".");
        String fileExtension = (lastDotIndex != -1) ? originalFilename.substring(lastDotIndex + 1) : "";
        try {
            // path will be changed after deployement
            file.transferTo(new File("/home/ahmed/Z-learning/recources/" + course.getId() + "_" + LocalDateTime.now().withSecond(0).withNano(0) + fileExtension));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving file");
        }
        String image = "/home/ahmed/Z-learning/recources/" + course.getId() + "_" + LocalDateTime.now().withSecond(0).withNano(0) + fileExtension;
        if (course != null) {
            course.setMainImagePath(image);
            courseRepo.save(course);
        }
    }


    public byte[] getImageContent(String certifId) throws IOException {
        Course course = courseRepo.findById(certifId)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Certif by ID %s", certifId)));

        String imagePath = course.getMainImagePath();
        File file = new File(imagePath);

        return Files.readAllBytes(file.toPath());
    }

    public ArrayList<Course> getAllCertifsByIds(ArrayList<String> ids){
        ArrayList<Course> courses = new ArrayList<>();
        for (String id : ids){
            courses.add(courseRepo.findById(id).orElse(null));
        }
        return courses;
    }
    public void deleteCertif(String id){
        courseRepo.deleteById(id);
    }

    public int getCoursesNr() {
        return courseRepo.findAll().size();
    }

    public Course getCertifById(String id){
        return courseRepo.findById(id).orElse(null);
    }
}
