package com.example.FawryTask.Controller;

import com.example.FawryTask.GlobalEnums.ResponseMessage;
import com.example.FawryTask.Model.Request.FilmReqDto;
import com.example.FawryTask.Model.Response.Response;
import com.example.FawryTask.Services.FilmsService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/films")
@CrossOrigin("http://localhost:4200")
public class FilmUserController {
    @Autowired
    private FilmsService filmsService;

    @RequestMapping(value = "/api/user/films/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findByTitle")
    public ResponseEntity<?> getFilmFromDbByTitle(@RequestParam String title)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("findByTitle"),
                filmsService.getFilmFromDBByTitle(title)));
    }
    @GetMapping("/addRating")
    public ResponseEntity<?> addRatingForFilm(@RequestParam String imdbId,@RequestParam Integer rating)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("addRatingForFilm"),
                filmsService.addRatingForFilm(imdbId,rating)));
    }
    @GetMapping("/searchWithSpecs")
    public ResponseEntity<?> getFilmWithSpecs(@RequestBody FilmReqDto filmReqDto)
    {
        Pageable pageable = PageRequest.of(filmReqDto.getPageNumber(), filmReqDto.getPageSize());
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("searchWithSpecs"),
                filmsService.getFilmWithSpecs(filmReqDto,pageable)));
    }
}
