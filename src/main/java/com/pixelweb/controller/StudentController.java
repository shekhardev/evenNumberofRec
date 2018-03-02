package com.pixelweb.controller;

import com.pixelweb.model.Student;
import com.pixelweb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/getstu")
    public String getStudents(Model model){
        List<Student> students = new ArrayList<>();
       studentRepository.findAll()
                .forEach(students::add);

       //to Get Even number of Records from DB
        List<Student> result =students.stream()
                .filter(p->p.getId() %2 ==0)
               .collect(Collectors.toList());
        result.forEach(System.out::println);

        // to sum up all ages in DB
        int sum =students.stream()
                .mapToInt(Student::getAge)
                .sum();
        System.out.println("Sum of ages (sum operation): " +
                sum);

        // 1. Average age of male members, average operation

        double average = students
                .stream()
                
                .mapToInt(Student::getAge)
                .average()
                .getAsDouble();

        System.out.println("Average age (bulk data operations): " +
                average);

        model.addAttribute("stu",result);
         return "student";
    }

}
