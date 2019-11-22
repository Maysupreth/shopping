package com.example.product.repositories;

import com.example.product.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<Items,Long> {
    Items findAllById(Long id) ;
}
