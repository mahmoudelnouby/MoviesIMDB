package com.example.FawryTask.Security.Controller;


import com.example.FawryTask.Security.Response.JwtAuthenticationResponse;
import com.example.FawryTask.Security.Services.AuthenticationService;
import com.example.FawryTask.Security.request.SignInRequest;
import com.example.FawryTask.Security.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {
    @Autowired
    private final AuthenticationService authenticationService;
    @PostMapping("signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}