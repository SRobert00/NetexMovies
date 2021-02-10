package com.academy.netex.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "movies")
public class MovieModel implements Serializable {

    @Id
    @Field
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Field
    @Column(name = "title")
    @JsonProperty("Title")
    private String title;

    @Field
    @Column(name = "year")
    @JsonProperty("year")
    private String year;

    @Field
    @Column(name = "imdb")
    @JsonProperty("imdbID")
    private String imdb;

    @Field
    @Column(name = "type")
    @JsonProperty("Type")
    private String type;

    @Field
    @Column(name = "poster")
    @JsonProperty("Poster")
    private String poster;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter("Title")
    public String getTitle() {
        return title;
    }

    @JsonSetter("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonGetter("Year")
    public String getYear() {
        return year;
    }

    @JsonSetter("Year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonGetter("ImdbID")
    public String getImdb() {
        return imdb;
    }

    @JsonSetter("ImdbID")
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    @JsonGetter("Type")
    public String getType() {
        return type;
    }

    @JsonSetter("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonGetter("Poster")
    public String getPoster() { return poster; }

    @JsonSetter("Poster")
    public void setPoster(String poster) { this.poster = poster; }

    @Override
    public String toString() {
        return "MovieModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdb='" + imdb + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
