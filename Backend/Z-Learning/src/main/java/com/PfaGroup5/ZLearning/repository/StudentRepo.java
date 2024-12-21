package com.PfaGroup5.ZLearning.repository;

import com.PfaGroup5.ZLearning.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

}
