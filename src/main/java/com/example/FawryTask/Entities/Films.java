package com.example.FawryTask.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "Films")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Films {
    @Id
    @Column(name = "imdbID")
    @NotNull
    @JsonProperty("imdbID")
    private String imdbID;
    @Column(name = "Title")
    @JsonProperty("Title")
    @NotNull
    private String title;
    @Column(name = "\"year\"")
    @JsonProperty("Year")
    @NotNull
    private String year;
    @Column(name = "Rated")
    @JsonProperty("Rated")
    private String rated;
    @Column(name = "Released")
    @JsonProperty("Released")
    @JsonFormat(pattern = "dd MMM yyyy")
    private String released;
    @Column(name = "Runtime")
    @JsonProperty("Runtime")
    private String runTime;
    @Column(name = "Genre")
    @JsonProperty("Genre")
    private String genre;
    @Column(name = "Director")
    @JsonProperty("Director")
    private String director;
    @Column(name = "Writer")
    @JsonProperty("Writer")
    private String writer;
    @Column(name = "Actors")
    @JsonProperty("Actors")

    private String actors;
    @Column(name = "Plot")
    @JsonProperty("Plot")
    private String plot;
    @Column(name = "Language")
    @JsonProperty("Language")
    private String language;
    @Column(name = "Country")
    @JsonProperty("Country")
    private String country;
    @Column(name = "Awards")
    @JsonProperty("Awards")
    private String awards;
    @Column(name = "Poster")
    @JsonProperty("Poster")
    @NotNull
    private String poster;
    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("Ratings")
    private List<Rating> ratings;
    @Column(name = "Metascore")
    @JsonProperty("Metascore")
    private String metaScore;
    @Column(name = "imdbRating")
    @JsonProperty("imdbRating")
    private String imdbRating;
    @Column(name = "imdbVotes")
    @JsonProperty("imdbVotes")
    private String imdbVotes;
    @Column(name = "Type")
    @JsonProperty("Type")
    @NotNull
    private String type;
    @Column(name = "DVD")
    @JsonProperty("DVD")
    private String dvd;
    @Column(name = "BoxOffice")
    @JsonProperty("BoxOffice")
    private String boxOffice;
    @Column(name = "Production")
    @JsonProperty("Production")
    @Nullable
    private String production;
    @Column(name = "Website")
    @JsonProperty("Website")
    @Nullable
    private String webSite;
    @Column(name = "totalSeasons")
    @JsonProperty("totalSeasons")
    @Nullable
    private String totalSeasons;
    @Column(name = "Response")
    @JsonProperty("Response")
    private String response;

}
