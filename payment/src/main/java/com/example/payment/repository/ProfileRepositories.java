package com.example.payment.repository;

import com.example.payment.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepositories  extends JpaRepository<Profile,String> {

}
