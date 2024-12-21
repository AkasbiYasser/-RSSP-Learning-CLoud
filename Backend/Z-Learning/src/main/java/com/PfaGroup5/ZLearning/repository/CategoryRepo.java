package com.PfaGroup5.ZLearning.repository;

import com.PfaGroup5.ZLearning.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends MongoRepository<Category,String> {
    Category findByName(String name);
}
