package com.vttp.springsecurity.jwt.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vttp.springsecurity.jwt.models.Cardholder;
import com.vttp.springsecurity.jwt.security.JwtUtil;
import com.vttp.springsecurity.jwt.services.CardholderService;

@RestController 
@RequestMapping (produces=MediaType.APPLICATION_JSON_VALUE)
public class CardholderController {
    
    @Autowired
    private CardholderService cardholderService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(path="/api/auth/signin", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> greeting(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {

        String token = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
        }
            

        String email = jwtUtil.getUsernameFromToken(token);
        Optional<Cardholder> cardholderOpt = cardholderService.getCardholder(email);
        Cardholder cardholder = cardholderOpt.get();
        
        return ResponseEntity.ok("Welcome " + cardholder.getUsername() + "!");
        //return ResponseEntity.ok(cardholder);
    }

    @PostMapping(path="/signup", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser (@RequestBody Cardholder cardholder) {
        
        if(cardholder.getUserId() == null || cardholder.getUserId() == "") {
            String generatedId = UUID.randomUUID().toString().substring(0, 8);
            cardholder.setUserId(generatedId);
        }

        try {
            cardholderService.createCardholder(cardholder);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error occured in registering user.");
        }

        return ResponseEntity.status(HttpStatus.OK).body("User registered successfully.");
    }
}
