package com.harxsh.spring.rest.api.controller.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("v1.StudentController")
@RequestMapping("/api/v1/students")
@PropertySource("classpath:test.properties")
@Slf4j
public class StudentController {

    @Value("${test.message}")
    private String testMessage;

    @GetMapping("test")
    @ResponseBody
    public String test() {
        log.info("Inside test method: {}", testMessage);
        return testMessage;
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(
                List.of(new Student("Harxsh", 25, List.of("Java", "Spring", "Microservices"))),
                HttpStatus.OK
        );
    }

    record Student(String name, int age, List<String> courses) {}
}
