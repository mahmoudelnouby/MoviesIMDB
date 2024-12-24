package com.example.FawryTask.Repos;

import com.example.FawryTask.Entities.Films;
import com.example.FawryTask.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmsRepo extends JpaRepository<Films,String> {
    List<Films> findByTitle(@Param("Title") String title);
    @Query("SELECT f FROM Films f WHERE f.title LIKE %:Title%")
    List<Films> findByTitleContaining(@Param("Title") String title);

}
