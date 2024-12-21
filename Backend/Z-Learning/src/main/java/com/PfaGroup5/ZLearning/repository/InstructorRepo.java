package com.PfaGroup5.ZLearning.repository;

import com.PfaGroup5.ZLearning.model.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends MongoRepository<Instructor, String> {


}
