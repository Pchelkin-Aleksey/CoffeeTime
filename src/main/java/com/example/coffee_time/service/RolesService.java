package com.example.coffee_time.service;

import com.example.coffee_time.entity.Role;
import com.example.coffee_time.repository.RolesRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class RolesService {

    private final RolesRepository rolesRepository;

    public List<Role> findAll(){
        return rolesRepository.findAll();
    }
}