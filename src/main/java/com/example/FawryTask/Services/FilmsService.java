package com.example.FawryTask.Services;

import com.example.FawryTask.Entities.Films;
import com.example.FawryTask.Entities.Rating;
import com.example.FawryTask.Model.Response.FilmDto;
import com.example.FawryTask.Model.Response.SearchResponse;
import com.example.FawryTask.Repos.FilmsRepo;
import com.example.FawryTask.Repos.RatingRepo;
import com.example.FawryTask.Utils.IntegerUtils;
import com.example.FawryTask.Utils.StringUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmsService {
    private final WebClient webClient;
    @Autowired
    private FilmsRepo filmsRepo;
    @Autowired
    private RatingRepo ratingRepo;
    @Value("${apiKey}")
    private String apiKey;

    public FilmsService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.omdbapi.com").build();
    }
    public Mono<Films> getMovieDetails(String title) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("t", title)
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(Films.class);
    }
    public Mono<SearchResponse> getMovies(String title,Integer page) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("s", title)
                        .queryParam("apikey", apiKey)
                        .queryParam("page",page)
                        .build())
                .retrieve()
                .bodyToMono(SearchResponse.class);
    }


    public List<FilmDto> getListOfFilms(String title,Integer page)
    {
        if(StringUtils.isNull(title))
        {
            throw new RuntimeException("Title Cannot Be Empty!");
        }
        List<FilmDto> filmDtos= getMovies(title,page).block().getSearch();
        return filmDtos;
    }
    public Page<Films> getAllFilms(Pageable pageable) {
        return filmsRepo.findAll(pageable);
    }

    public Films getFilmByTitle(String title) {

        Films film= getMovieDetails(title).block();
        List<Rating> rating = film.getRatings();
        rating.stream().map(rating1 -> {
            rating1.setFilm(film);
            return rating1;
        }).collect(Collectors.toList());
        return film;
    }
    public ResponseEntity<?> saveFilmToDataBase(List<FilmDto> film) {
        for(FilmDto films : film)
        {
            Films filmDetails=getFilmByTitle(films.getTitle());
            List<Rating> rating = filmDetails.getRatings();
            rating.stream().map(rating1 -> {
                rating1.setFilm(filmDetails);
                return rating1;
            }).collect(Collectors.toList());
            filmsRepo.save(filmDetails);
            ratingRepo.saveAll(rating);
        }

        return ResponseEntity.ok("Saved Successfully");
    }

    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Transactional
    public ResponseEntity<?> deleteFilmByTitle(List<String> imdpid) {

        for(String imdbid : imdpid)
        {
            if(StringUtils.isNull(imdbid))
            {
                throw new RuntimeException("IMDB ID is Mandatory!");
            }
            if (!filmsRepo.existsById(imdbid))
            {
                throw new RuntimeException("Film With This Title Not Found!");
            }
            try {
                filmsRepo.deleteById(imdbid);

            } catch (Exception e) {
                System.err.println("Error deleting film with IMDB ID: " + imdbid);
                e.printStackTrace();
                throw new RuntimeException("Failed to delete film with IMDB ID: " + imdbid);
            }

        }
        return ResponseEntity.ok("Deleted Successfully");
    }

    public List<Films> getFilmFromDBByTitle(String title) {
        if(StringUtils.isNull(title))
        {
            throw new RuntimeException("Cannot Search With Title Empty!");
        }
        return filmsRepo.findByTitleContaining(title);
    }

    public ResponseEntity<?> addRatingForFilm(String imdbId, Integer rating) {
        if(StringUtils.isNull(imdbId))
        {
            throw new RuntimeException("Please Choose Film To Add Rating!");
        }
        if(IntegerUtils.isNull(rating))
        {
            throw new RuntimeException("Cannot Enter Empty Rating!");
        }
        Optional<Films> films=filmsRepo.findById(imdbId);
        if(!filmsRepo.existsById(imdbId))
        {
            throw new RuntimeException("Film Not Exist!");
        }
         ratingRepo.save(Rating.builder().
                film(films.get()).
                value(String.valueOf(rating)).
                source("FawryTask").build());
        return ResponseEntity.ok("Rating Added Successfully");
    }
}
