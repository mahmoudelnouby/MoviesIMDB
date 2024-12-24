package com.example.FawryTask.Model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FilmReqDto {
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
    private Integer pageNumber;
    private Integer pageSize;

    public Integer getPageNumber() {
        return pageNumber != null ? pageNumber : 0;
    }

    public Integer getPageSize() {
        return pageSize != null ? pageSize : 5;
    }
}
