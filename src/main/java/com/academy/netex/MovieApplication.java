package com.academy.netex;

import com.academy.netex.controller.MovieController;
import com.academy.netex.model.MovieModel;
import com.academy.netex.repo.MovieRepo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

@SpringBootApplication
@PropertySource("application.properties")
public class MovieApplication {

    public static void main(String[] args) {
      SpringApplication.run(MovieApplication.class, args);

      //added 100 movies the database using the method from the controller constructor
      //commented the sout and addMovie from it


        }
    }

