package com.scb.shopping.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.scb.shopping.model.PaymentResponse;
import com.scb.shopping.model.User;
import com.scb.shopping.model.UserRequest;
import com.scb.shopping.repositories.PaymentClient;
import com.scb.shopping.repositories.UserRepository;
import com.scb.shopping.repositories.UserRepositoryV2;
import lombok.AllArgsConstructor;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.List;

@Service
@RibbonClient("payment-service")
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserRepositoryV2 userRepositoryV2;

    private final PaymentClient paymentClient;



    @HystrixCommand(fallbackMethod = "createUserRecovery")
    public User createUser(User user) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setUsername(user.getUsername());
        paymentResponse.setBalance(user.getBalance());

        PaymentResponse profile = paymentClient.addUser(paymentResponse);
        System.out.println(profile);
        return userRepository.save(user);
    }

    public User createUserRecovery(User user) {
        user.setAddress(null);
        user.setBalance(null);
        user.setPassword(null);
        user.setUsername(null);

        return user;
    }
    public List<User> searchUser(UserRequest userRequest){
        return userRepositoryV2.searchAll(userRequest.getUsername());
    }



    public User getUserByUsername(String username) {
        return userRepositoryV2.getUserByUsername(username);
    }

    public User updateUserById(Long id, @Valid User user) {
        user.setId(id);

        if (userRepository.findById(id).isPresent()) {

            return userRepository.save(user);
        }
        return null;
    }




}




