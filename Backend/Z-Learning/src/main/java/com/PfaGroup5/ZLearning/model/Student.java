package com.PfaGroup5.ZLearning.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String imagePath;
}
