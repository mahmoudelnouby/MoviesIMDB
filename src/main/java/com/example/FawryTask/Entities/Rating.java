package com.example.FawryTask.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "rating")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "imdbID", referencedColumnName = "imdbID")
    @JsonIgnore
    private Films film;

    @Column(name = "Source")
    @JsonProperty("Source")
    private String source;
    @Column(name = "\"value\"")
    @JsonProperty("Value")
    private String  value;
}
