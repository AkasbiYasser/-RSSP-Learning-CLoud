package com.PfaGroup5.ZLearning.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Instructor   {
    private String id;
    private String firstName;
    private String lastName;
    private String profession;
    private String imagePath;

}
