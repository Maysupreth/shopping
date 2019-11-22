package com.example.payment.model;

import lombok.Data;
import org.json.JSONObject;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Transaction {
    @Id
    private double id;

    private String username;
    private double amounts;
    private String products;




}
