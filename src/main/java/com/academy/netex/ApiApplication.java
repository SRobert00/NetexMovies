package com.academy.netex;

import com.academy.netex.controller.MovieController;
import com.academy.netex.model.MovieModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.zookeeper.server.admin.JsonOutputter;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ApiApplication {

    public static final String SEARCH_URL = "http://www.omdbapi.com/?s=TITLE&apikey=APIKEY&page=PAGE";

//    public static String ApiLink(String title, String key, String page) {

//        try {
//            title = URLEncoder.encode(title, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String requestUrl = SEARCH_URL.replaceAll("TITLE", title).replaceAll("APIKEY", key).replaceAll("PAGE", page);
//        return requestUrl;
//    }

    //    public static MovieModel sendGetRequest(String requestUrl){
//        //StringBuffer response = new StringBuffer();
//        MovieModel movie = new MovieModel();
//
//        try {
//            URL url = new URL(requestUrl);
//            ObjectMapper om = new ObjectMapper();
//            om.configure(
//                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            movie = om.readValue(url, MovieModel.class);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Accept", "*/*");
//            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//            InputStream stream = connection.getInputStream();
//            InputStreamReader reader = new InputStreamReader(stream);
//            BufferedReader buffer = new BufferedReader(reader);
//            String line;
//            while((line = buffer.readLine()) != null){
//                response.append(line);
//            }
//            buffer.close();
//            connection.disconnect();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return movie;
//    }
//

//    private static String readAll(Reader reader) throws IOException {
//        StringBuilder stringBuilder = new StringBuilder();
//        int cp;
//        while ((cp = reader.read()) != -1) {
//            stringBuilder.append((char) cp);
//        }
//        return stringBuilder.toString();
//    }
//
//    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
//        InputStream is = new URL(url).openStream();
//        try {
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//            String jsonText = readAll(rd);
//            JSONObject json = new JSONObject(jsonText);
//            return json;
//        } finally {
//            is.close();
//        }
//    }


//    public static void main(String[] args){

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(
//                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        MovieModel movie = objectMapper.readValue(new URL("http://www.omdbapi.com/?t=batman&apikey=ecadf926"), MovieModel.class);

        //System.out.println(movie);

//        URL url = new URL("http://www.omdbapi.com/?s=batman&apikey=ecadf926");
//        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.connect();
//        int responsecode = conn.getResponseCode();
//        if(responsecode!= 200) {
//            throw new RuntimeException("httpResCode: " + responsecode);
//        }else{
//                Scanner sc = new Scanner(url.openStream());
//                String inline = new String();
//                while(sc.hasNext()){
//                    inline = sc.nextLine();
//                    System.out.println(" ");
//                    System.out.println(inline);
//                }
//                sc.close();
//
//            }


//        String url = ApiApplication.ApiLink("batman", "ecadf926", "1" );
//        try {
//            JSONObject json = readJsonFromUrl(url);
////            String jsonString = json.toString();
////            JSONObject jo = new JSONObject(jsonString);
//            JSONArray arr = json.getJSONArray("Search");
//            for(int i = 0; i < arr.length(); i++){
//
//                ObjectMapper mapper = new ObjectMapper();
//                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//                JSONObject JsonMovie = arr.getJSONObject(i);
//                String stringMovie = JsonMovie.toString(1);
//                MovieModel movies = mapper.readValue(stringMovie, MovieModel.class);
//                System.out.println(movies);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


//        for(int i= 1; i<=10; i++) {
//            String page = String.valueOf(i);
//            MovieModel jsonResponse = ApiApplication.searchMovieByTitle("batman", "ecadf926", page);
//            System.out.println(jsonResponse);
//        }
//        String jsonRespons = ApiApplication.searchMovieByTitle("batman", "ecadf926", "2");
//        System.out.println(jsonRespons);
//        }

//        int number = 0;
//        try {
//            for (int i = 1; i <= 10; i++) {
//                String page = String.valueOf(i);
//                //String url = MovieController.ApiLink("batman", "ecadf926", page);
//                JSONObject json = readJsonFromUrl(url);
//                JSONArray arr = json.getJSONArray("Search");
//                for (int j = 0; j < arr.length(); j++) {
//
//                    ObjectMapper mapper = new ObjectMapper();
//                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//                    JSONObject JsonMovie = arr.getJSONObject(j);
//                    String stringMovie = JsonMovie.toString(1);
//                    MovieModel movies = mapper.readValue(stringMovie, MovieModel.class);
//                    System.out.println(movies);
//                    number++;
//                }
//            }
//
//        } catch (JSONException | IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(number);

 }



