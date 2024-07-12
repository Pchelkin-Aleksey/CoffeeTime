package com.example.coffee_time.repository;

import com.example.coffee_time.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
