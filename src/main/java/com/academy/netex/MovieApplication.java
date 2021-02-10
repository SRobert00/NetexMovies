package com.academy.netex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("application.properties")
public class MovieApplication {

    public static void main(String[] args) {
      SpringApplication.run(MovieApplication.class, args);

      //added 100 movies the database using the method from the controller constructor
      //commented the sout and addMovie from it




        }
    }

