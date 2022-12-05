package com.vttp.springsecurity.jwt.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vttp.springsecurity.jwt.models.Cardholder;
import com.vttp.springsecurity.jwt.payload.JwtRequest;
import com.vttp.springsecurity.jwt.payload.JwtResponse;
import com.vttp.springsecurity.jwt.security.JwtUtil;
import com.vttp.springsecurity.jwt.services.CardholderService;
import com.vttp.springsecurity.jwt.services.JwtUserDetailsService;

@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsSvc;

    @Autowired
    private CardholderService cardholderSvc;
    
    @PostMapping (path="/authenticate")
    public ResponseEntity<?> createAuthentication (@RequestBody JwtRequest jwtRequest) {
        String email = jwtRequest.getEmail();
        String password = jwtRequest.getPassword();

        try {
            authenticate(email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        final UserDetails userDetails = jwtUserDetailsSvc
                .loadUserByUsername(email);

        final String token = jwtUtil.generateToken(userDetails);

        Optional<Cardholder> cardholderOpt = cardholderSvc.getCardholder(email);
        Cardholder cardholder = cardholderOpt.get();
        String cardholderUserId = cardholder.getUserId();
        String cardholderUsername = cardholder.getUsername();
        String cardholderFirstName = cardholder.getFirstName();
        String cardholderLastName = cardholder.getLastName();
        String cardholderEmail = cardholder.getEmail();
        

        return ResponseEntity.ok(new JwtResponse(token, cardholderUserId, cardholderUsername, cardholderFirstName, cardholderLastName, cardholderEmail));
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
