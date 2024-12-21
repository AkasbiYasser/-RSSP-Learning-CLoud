package com.PfaGroup5.ZLearning.service;

import com.PfaGroup5.ZLearning.model.Course;
import com.PfaGroup5.ZLearning.model.User;
import com.PfaGroup5.ZLearning.repository.CourseRepo;
import com.PfaGroup5.ZLearning.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSevice {

    final public CourseRepo courseRepo;
    final public UserRepo userRepo;

    public UserSevice(UserRepo userRepo, CourseRepo courseRepo) {
        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
    }


    public User loginValidation(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }

    public User register(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("Email already exists");
        }
        userRepo.save(user);
        return user;
    }

    public void deleteUser(String id){
        userRepo.deleteById(id);
    }

    public void enrollCourse(String userID, String courseID) {
        User user = userRepo.findById(userID).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find User by Id %s", userID)));
        Course course = courseRepo.findById(courseID).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Course by Id %s", courseID)));
        List<Course> courses = new ArrayList<>(user.getCourseList());
        courses.add(course);
        user.setCourseList(courses);
        userRepo.save(user);
    }

    public void unenrollCourse(String userID, String courseID) {
        User user = userRepo.findById(userID).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find User by Id %s", userID)));
        Course course = courseRepo.findById(courseID).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Course by Id %s", courseID)));
        List<Course> courses = new ArrayList<>(user.getCourseList());
        courses.remove(course);
        user.setCourseList(courses);
        userRepo.save(user);
    }

    public List<Course> getCourses(String userID) {
        User user = userRepo.findById(userID).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find User by Id %s", userID)));

        return user.getCourseList();
    }

}
