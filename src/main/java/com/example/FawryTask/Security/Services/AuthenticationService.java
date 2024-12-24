package com.example.FawryTask.Security.Services;


import com.example.FawryTask.Security.Response.JwtAuthenticationResponse;
import com.example.FawryTask.Security.request.SignInRequest;
import com.example.FawryTask.Security.request.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}