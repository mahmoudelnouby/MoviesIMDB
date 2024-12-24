package com.example.FawryTask.Controller;

import com.example.FawryTask.GlobalEnums.ResponseMessage;
import com.example.FawryTask.Model.Response.Response;
import com.example.FawryTask.Services.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/films")
@CrossOrigin("http://localhost:4200")
public class FilmsController {
    @Autowired
    private FilmsService filmsService;

    @RequestMapping(value = "/api/films/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<?> getAllFilms(@PageableDefault(page = 0, size = 5, sort = "title") Pageable pageable)
    {
        return ResponseEntity.ok(new Response(200,
                ResponseMessage.Succesful_Request.getMessage(),
                ResponseMessage.Developer_Message.getMessageByApi("getAllFilms"),
                filmsService.getAllFilms(pageable)));
    }

}
