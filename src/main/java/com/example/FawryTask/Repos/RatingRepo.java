package com.example.FawryTask.Repos;

import com.example.FawryTask.Entities.Films;
import com.example.FawryTask.Entities.Rating;
import com.example.FawryTask.Security.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {
    @Modifying
    @Query("delete from Rating r where r.film.imdbID = :imdbID")
    Integer deleteByImdbID(@Param("imdbID") String title);
    @Query("select r from Rating r where r.film.imdbID = :imdbID")
    List<Rating> findByImdbID(@Param("imdbID") String title);
}
