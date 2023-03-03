package com.vttp.springsecurity.jwt.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vttp.springsecurity.jwt.models.Cardholder;
import com.vttp.springsecurity.jwt.repositories.CardholderRepositories;

@Service
public class CardholderService {
    
    @Autowired
    private CardholderRepositories cardholderRepositories;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Optional<Cardholder> getCardholder (String email) {
        Optional<Cardholder> cardholderOpt = cardholderRepositories.findByEmail(email);

        if (cardholderOpt.isEmpty()) {
            return Optional.empty();
        }

        return cardholderOpt;
    }

    public void createCardholder (Cardholder cardholder) throws Exception {
        if(cardholderRepositories.existsByEmail(cardholder.getEmail())){
            throw new Exception("Email has been used. Try a new email address.");
        }

        if(cardholderRepositories.existsByUsername(cardholder.getUsername())) {
            throw new Exception("Username has been used. Create a unique username.");
        }

        String password = bCryptPasswordEncoder.encode(cardholder.getPassword());
        cardholder.setPassword(password);
        cardholderRepositories.insertNewUser(cardholder);
    }

    public void removeCardholder (String username) throws Exception {
        
        if (!cardholderRepositories.deleteByUsername(username)) {
            throw new Exception("There is no such username present in our record");
        }
    }
}
