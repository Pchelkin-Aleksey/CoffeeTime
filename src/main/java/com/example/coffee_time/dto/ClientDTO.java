package com.example.coffee_time.dto;

import com.example.coffee_time.entity.Client;

import java.time.LocalDate;

public record ClientDTO(
        Long id,
        Long chat_id,
        String name,
        LocalDate birthday,
        String email,
        String registration_state) {

    public Client toEntity() {
        return new Client(id,chat_id,name,birthday,email,registration_state);
    }

    public ClientDTO fromEntity(Client client) {
        return client == null
                ? new ClientDTO(null,null,null,null,null,null)
                : new ClientDTO(client.getId(),client.getChat_id(), client.getName(), client.getBirthday(), client.getEmail(), client.getRegistration_state());
    }
}
