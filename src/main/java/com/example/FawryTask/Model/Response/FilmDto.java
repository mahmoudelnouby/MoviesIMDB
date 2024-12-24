package com.example.FawryTask.Model.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FilmDto {
    @JsonProperty("Title")
    @NotNull
    private String title;
    @JsonProperty("Year")
    @NotNull
    private String year;
    @JsonProperty("imdbID")
    @NotNull
    private String imdbId;
    @JsonProperty("Type")
    @NotNull
    private String type;
    @JsonProperty("Poster")
    @NotNull
    private String poster;
}