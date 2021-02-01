package com.academy.netex;

import com.academy.netex.controller.MovieController;
import com.academy.netex.model.MovieModel;
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
    public static final String SEARCH_URL = "http://www.omdbapi.com/?s=TITLE&apikey=APIKEY&page=PAGE";

    public static String ApiLink(String title, String key, String page){

        try {
            title = URLEncoder.encode(title, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String requestUrl = SEARCH_URL.replaceAll("TITLE", title).replaceAll("APIKEY", key).replaceAll("PAGE", page);
        return requestUrl;
    }

    private static String readAll(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            stringBuilder.append((char) cp);
        }
        return stringBuilder.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }



    public static void main(String[] args) {
      SpringApplication.run(MovieApplication.class, args);

        MovieController movieController = new MovieController();
        try {
                for (int i = 1; i <= 10; i++) {
                    String page = String.valueOf(i);
                    String url = MovieApplication.ApiLink("batman", "ecadf926", page);
                    JSONObject json = readJsonFromUrl(url);
                    JSONArray arr = json.getJSONArray("Search");
                    for (int j = 0; j < arr.length(); j++) {

                        ObjectMapper mapper = new ObjectMapper();
                        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        JSONObject JsonMovie = arr.getJSONObject(j);
                        String stringMovie = JsonMovie.toString(1);
                        MovieModel movie = mapper.readValue(stringMovie, MovieModel.class);
                        //ArrayList<MovieModel> movies = new ArrayList<>();
                        //movies.add(movie);
                        System.out.println(movie);
                        movieController.addMovie(movie);


                    }
                }

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }

        }
    }

