package com.pixelweb.controller;

import com.pixelweb.model.Student;
import com.pixelweb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getstu")
    public List<Student> getEvenStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll()
                .forEach(students::add);

       students.stream()
                .filter(p->p.getId() %2 ==0)
               .forEach(System.out::println);

        return students;
    }
}
