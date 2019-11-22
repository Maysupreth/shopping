package com.example.payment.service;

import com.example.payment.model.Profile;
import com.example.payment.model.Request;
import com.example.payment.repository.ProfileRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepositories profileRepositories;

    public Profile createProfile(Profile body){
        return profileRepositories.save(body);
    }

    public Optional<Profile> getProfile(String user){
        return profileRepositories.findById(user);
    }

    public Profile updateBalance(String username,Profile body){
        if( profileRepositories.findAllById(Collections.singleton(username)) != null){
            Profile profile = profileRepositories.save(body);
            return profile;
        }else{
            return (Profile) profileRepositories.findAllById(Collections.singleton(username));
        }
    }

    public void paymentProcess(Request body){
        for(int i =0;i< body.getProducts().size();i++){
            int productID = body.getProducts().get(i).getProduct_id();
        }


    }
}
