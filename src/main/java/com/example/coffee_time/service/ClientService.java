package com.example.coffee_time.service;

import com.example.coffee_time.entity.Client;
import com.example.coffee_time.exception.EntityNotFoundException;
import com.example.coffee_time.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("not found client", id)));
    }

}
