package com.academy.netex.controller;


import com.academy.netex.model.MovieModel;
import com.academy.netex.model.QMovieModel;
import com.academy.netex.service.MovieService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

@RestController
public class MovieController {
        public static final String SEARCH_URL = "http://www.omdbapi.com/?s=TITLE&type=movie&apikey=APIKEY&page=PAGE";


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


    private MovieService service;


    public MovieController(MovieService service) {
        this.service = service;

        try {
            for (int i = 1; i <= 10; i++) {
                String page = String.valueOf(i);
                String url = MovieController.ApiLink("star", "ecadf926", page);
                JSONObject json = readJsonFromUrl(url);
                JSONArray arr = json.getJSONArray("Search");
                for (int j = 0; j < arr.length(); j++) {

                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    JSONObject JsonMovie = arr.getJSONObject(j);
                    String stringMovie = JsonMovie.toString(1);
                    MovieModel movie = mapper.readValue(stringMovie, MovieModel.class);
                    //System.out.println(movie);
                    //addMovie(movie);

                }
            }

        } catch (JSONException | IOException e ) {
            e.printStackTrace();
        }

    }

    @GetMapping("/getMoviesOrderedByYear")
    public List<MovieModel> getMoviesOrderedByYear(){
        return service.getJPAQueryFactory()
                .selectFrom(QMovieModel.movieModel)
                .orderBy(QMovieModel.movieModel.year.asc())
                .fetch();
    }

    @GetMapping("/getMoviesThatContainsTitle/{title}")
    public List<MovieModel> getMoviesThatContainsTitle(@PathVariable String title){
        return service.getJPAQueryFactory()
                .selectFrom(QMovieModel.movieModel)
                .where(QMovieModel.movieModel.title.contains(title))
                .fetch();
    }

    @GetMapping("/getMoviesBetweenYears/{from} {to}")
    public List<MovieModel> getMoviesBetweenYears(@PathVariable Integer from, @PathVariable Integer to){
        return service.getJPAQueryFactory()
                .selectFrom(QMovieModel.movieModel)
                .where(QMovieModel.movieModel.year.between(from, to))
                .fetch();
    }

    @GetMapping("/getMovieById/{id}")
    public List<MovieModel> getMovieById(@PathVariable Integer id) {
        return service.getJPAQueryFactory()
                .selectFrom(QMovieModel.movieModel)
                .where(QMovieModel.movieModel.id.eq(id))
                .fetch();
    }

    @GetMapping("/getMoviesFromYear/{year}")
    public List<MovieModel> getMoviesFromYear(@PathVariable Integer year){
        return service.getJPAQueryFactory()
                .selectFrom(QMovieModel.movieModel)
                .where(QMovieModel.movieModel.year.eq(year))
                .fetch();
    }

    @PostMapping("/addMovie")
    public MovieModel addMovie(@RequestBody MovieModel movie){ return service.saveMovie(movie); }

    @PostMapping("/addMovies")
    public List<MovieModel> addMovies(@RequestBody List<MovieModel> movie){
        return service.saveMovies(movie);
    }

    @GetMapping("/movies")
    public List<MovieModel> findAllMovies(){
        return service.getMovies();
    }

    @GetMapping("/movieById/{id}")
    public MovieModel findMovieById(@PathVariable int id){
        return service.getMovieById(id);
    }
    @PutMapping("/update")
    public MovieModel updateMovie(@RequestBody MovieModel movie){
        return service.updateMovie(movie);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id){
        return service.deleteMovie(id);
    }


}
