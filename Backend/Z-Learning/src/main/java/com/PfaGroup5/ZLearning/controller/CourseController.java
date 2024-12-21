package com.PfaGroup5.ZLearning.controller;


import com.PfaGroup5.ZLearning.model.Course;
import com.PfaGroup5.ZLearning.service.CourseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
    @RequestMapping("Api/Certif")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity addCertif(@RequestBody Course course) {
        courseService.addCertif(course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCertif() {
        return ResponseEntity.ok(courseService.getAllCertif());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Course> getCertifByName(@PathVariable String name) {
        return ResponseEntity.ok(courseService.getCertifByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCertif(@PathVariable String id, @RequestBody Course course) {
        courseService.updateCertif(id, course);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/uploadCertifImage/{id}")
    public ResponseEntity<String> uploadImage(@PathVariable String id, @RequestParam("file") MultipartFile file){
        try {
            courseService.storeImage(id, file);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }


    @GetMapping("/downloadCertifImage/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String id) {
        try {
            byte[] fileContent = courseService.getImageContent(id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Change the content type based on your file extension
            headers.setContentDispositionFormData("attachment", "image.jpg"); // Set the desired file title
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCertif(@PathVariable String id) {
        courseService.deleteCertif(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
