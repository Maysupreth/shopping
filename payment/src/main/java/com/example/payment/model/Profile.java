package com.example.payment.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Profile {
    @Id
    private String username;

    private double balance;
}
