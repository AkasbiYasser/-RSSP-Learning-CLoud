package com.PfaGroup5.ZLearning.repository;

import com.PfaGroup5.ZLearning.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRepo extends MongoRepository<Course,String> {
    @Query("{'title': ?0}")
    Optional<Course> findByTitle(String title);

}
