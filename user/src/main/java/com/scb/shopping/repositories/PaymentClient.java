package com.scb.shopping.repositories;

import com.scb.shopping.model.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient("payment-service")
public interface PaymentClient {

    @PostMapping("/payment/profile")
    PaymentResponse addUser(@RequestBody PaymentResponse body);



}
