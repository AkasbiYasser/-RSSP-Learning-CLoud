package com.PfaGroup5.ZLearning.repository;

import com.PfaGroup5.ZLearning.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    public User findByEmail(String email);
}
