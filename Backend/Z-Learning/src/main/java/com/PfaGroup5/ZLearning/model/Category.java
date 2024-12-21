package com.PfaGroup5.ZLearning.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Data
@Document
public class Category {
    @Id
    String id;
    String name;
    ArrayList<String> certifId = new ArrayList<>();


}
