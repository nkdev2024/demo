package com.helloworld.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.demo.BobyData.BodyData;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    public static class HelloWorldController {

        @GetMapping("/hello")
        public String hello() {
            return "Hello, World!";
        }

        @GetMapping("/greet")
        public String greet() {
            return "Greetings from Spring Boot!";
        }
         
        @PostMapping("/createUser")
    public String createUser(@RequestBody BodyData requestData) {
        String firstName = requestData.getFirstName();
        String lastName = requestData.getLastName();
        String password = requestData.getPassword();
        Number rollNumber = requestData.getRollNumber();
        return "hResource created successfully! Data received: " + firstName 
        + lastName + password + rollNumber;
    }

        
    @PostMapping("/getUser")
    public String getUser(@RequestBody BodyData requestData) {
        Number rollNumber = requestData.getRollNumber();
        return "hResource created successfully! Data received: " + rollNumber;
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody BodyData requestData) {
        Number rollNumber = requestData.getRollNumber();
        return "Resource updated successfully!" + rollNumber;
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody BodyData requestData) {
        Number rollNumber = requestData.getRollNumber();
        return "Resource deleted successfully!"+ rollNumber;
    }
        
    }
}
