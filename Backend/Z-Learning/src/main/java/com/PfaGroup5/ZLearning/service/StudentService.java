package com.PfaGroup5.ZLearning.service;

import com.PfaGroup5.ZLearning.model.Student;
import com.PfaGroup5.ZLearning.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public int getStudentsNr() {
        return studentRepo.findAll().size();
    }

    public void addStudent(Student student) {
        studentRepo.insert(student);
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student getStudentById(String id){
        return studentRepo.findById(id).orElse(null);
    }

    public void updateStudent(String id,Student student){
        studentRepo.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Student by Id %s", id)));
        Student oldStudent = studentRepo.findById(id).orElse(null);
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        oldStudent.setEmail(student.getEmail());

        studentRepo.save(oldStudent);

    }

    public void deleteStudent(String id){
        studentRepo.deleteById(id);
    }
}
