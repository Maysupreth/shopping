package com.example.payment.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Request {
    private List<ProductRequest> products;
}
