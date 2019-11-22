package com.example.payment.controller;


import com.example.payment.model.Profile;
import com.example.payment.model.Request;
import com.example.payment.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;




@RestController
@AllArgsConstructor
@Slf4j
public class PaymentController {

    private ProfileService profileService;

    @PostMapping(path="/profile")
    public ResponseEntity<?> createUser(@Valid @RequestBody Profile body){
        Profile user = profileService.createProfile(body);
        log.info("PAYMENT WAS CALLED");
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping(path="/profile/{username}")
    public ResponseEntity<?> createUser(@PathVariable String username){
        Optional<Profile> user = profileService.getProfile(username);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(path="/profile/{username}")
    public ResponseEntity<?> putCustomer(@PathVariable String username, @Valid @RequestBody Profile body){
        body.setUsername(username);
        Profile user = profileService.updateBalance(username,body);
        return user != null ? ResponseEntity.ok(user):ResponseEntity.notFound().build();
    }

    @GetMapping(path="/user")
    public Request test(@Valid @RequestBody Request body){
        return  body;
    }








}
