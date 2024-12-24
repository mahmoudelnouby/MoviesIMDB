package com.example.FawryTask.Model.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchResponse {
    @JsonProperty("Search")
    private ArrayList<FilmDto> search;
    private String totalResults;
    @JsonProperty("Response")
    private String response;
}
