package com.PfaGroup5.ZLearning.service;

import com.PfaGroup5.ZLearning.model.Instructor;
import com.PfaGroup5.ZLearning.repository.InstructorRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepo instructorRepo;

    public InstructorService(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    public int getInstructorsNr() {
        return instructorRepo.findAll().size();
    }

    public void addInstructor(Instructor instructor, MultipartFile file) {
        //save the file in the ./src/main/resources/static/images/instructors folder
        // get its path and put it in the instructor object
        //the filename should be the instructor's id

        if (file == null) {
            instructorRepo.insert(instructor);
            return;
        }
        String fileName = instructor.getId() + ".jpg";
        String path = "..../src/main/resources/images/" + fileName;
        try {
            file.transferTo(new File(path));
            instructor.setImagePath(path);
        } catch (IOException e) {
            e.printStackTrace();

        }
        instructorRepo.insert(instructor);
    }


    public List<Instructor> getAllInstructors(){
        return instructorRepo.findAll();
    }

    public Instructor getInstructorById(String id){
        return instructorRepo.findById(id).orElse(null);
    }

    public void updateInstructor(String id,Instructor instructor , MultipartFile file){
        if (file == null) {
            instructorRepo.findById(id).orElseThrow(() -> new RuntimeException(
                    String.format("Cannot Find Instructor by Id %s", id)));
            instructorRepo.save(instructor);
            return;
        }
        String fileName = instructor.getId() + ".jpg";
        String path = "..../src/main/resources/images/" + fileName;
        //delete the old image
        Instructor oldInstructor = instructorRepo.findById(id).orElse(null);
        if (oldInstructor != null) {
            File oldFile = new File(oldInstructor.getImagePath());
            oldFile.delete();
        }
        try {
            file.transferTo(new File(path));
            instructor.setImagePath(path);
        } catch (IOException e) {
            e.printStackTrace();

        }
        instructorRepo.save(instructor);
    }

    public void deleteInstructor(String id){
        Instructor instructor = instructorRepo.findById(id).orElse(null);
        if (instructor != null) {
//            File file = new File(instructor.getImagePath());
//            file.delete();
            instructorRepo.deleteById(id);

        }
    }


}