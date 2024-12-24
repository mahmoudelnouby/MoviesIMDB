//package com.example.FawryTask.Config;
//
//import com.example.FawryTask.Services.FilmsService;
//import jakarta.persistence.Column;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CommandRunner implements CommandLineRunner {
//    @Autowired
//    private FilmsService filmsService;
//    @Override
//    public void run(String... args) throws Exception {
//
//        System.out.println("at the Start of The Run");
//        for (char letter = 'a'; letter <= 'z'; letter++) {
//            System.out.println("letter :" +String.valueOf(letter));
//            filmsService.saveFilmFromIMDPToH2(String.valueOf(letter));
//        }
////        System.out.println(filmsService.saveFilmFromIMDPToH2("from"));
//        System.out.println("at the end of the command runner");
//    }
//}
