package com.vttp.springsecurity.jwt.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vttp.springsecurity.jwt.models.Cardholder;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private CardholderService cardholderService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Optional<Cardholder> cardholderOpt = cardholderService.getCardholder(email);

        if (cardholderOpt.isEmpty()) {
            throw new UsernameNotFoundException("User does not exist!");
        }

        Cardholder cardholder = cardholderOpt.get();

        return new User(cardholder.getEmail(), cardholder.getPassword(), new ArrayList<>());
    }
}
