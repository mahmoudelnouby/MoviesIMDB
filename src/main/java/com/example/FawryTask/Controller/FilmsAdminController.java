package com.example.FawryTask.Controller;

import com.example.FawryTask.Entities.Films;
import com.example.FawryTask.GlobalEnums.ResponseMessage;
import com.example.FawryTask.Model.Response.FilmDto;
import com.example.FawryTask.Model.Response.Response;
import com.example.FawryTask.Services.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/admin/films")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "Authorization")
public class FilmsAdminController {

    @Autowired
    private FilmsService filmsService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFilmsIMDB(@RequestParam String title,@RequestParam(defaultValue = "1") Integer page)
    {
        if(title.length()<3)
        {
            throw new RuntimeException("Minimum Title Word 3 Chars");
        }
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("getAll"),
                filmsService.getListOfFilms(title,page)));
    }

    @GetMapping("/getFilmByTitle")
    public ResponseEntity<?> getFilmByTitle(@RequestParam String title)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("getFilmByTitle"),
                filmsService.getFilmByTitle(title)));
    }
    @PutMapping("/saveFilm")
    public ResponseEntity<?> saveFilm(@RequestBody List<FilmDto> film)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("saveFilm"),
                filmsService.saveFilmToDataBase(film)));
    }
    @PostMapping("/deleteByTitle")
    public ResponseEntity<?> deleteFilm(@RequestBody List<String> imdpid)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("deleteByTitle"),
                filmsService.deleteFilmByTitle(imdpid)));
    }
    @GetMapping("/rating")
    public ResponseEntity<?> getAllRating()
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("rating"),
                filmsService.getAllRating()));
    }
}
