package com.example.FawryTask.Security.Services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServices {
    UserDetailsService userDetailsService();
}