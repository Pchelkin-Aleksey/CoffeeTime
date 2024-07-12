package com.example.coffee_time.dto;

import com.example.coffee_time.entity.Role;
import com.example.coffee_time.entity.User;


public record UserDTO( Long id,
        RoleDTO roles,
        String username,
        String password,
        String first_name,
        String last_name,
        String email,
        String phone_number) {

    public User toEntity(){
        return new User(
                id,
                roles.toEntity(),
                username,
                password,
                first_name,
                last_name,
                email,
                phone_number
        );
    }

    static UserDTO fromEntity(User user) {
        Role role = user.getRole() != null ? role = user.getRole() : new Role();
        return user == null
                ? new UserDTO(null, null, null, null, null, null, null, null)
                : new UserDTO(user.getId(), RoleDTO.fromEntity(role), user.getUsername(), user.getPassword(), user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPhone_number());
    }


    public static UserDTO toDto(User user) {
        Role role = user.getRole() != null ? user.getRole() : new Role();
        return new UserDTO(
                user.getId(),
                RoleDTO.fromEntity(role),
                user.getUsername(),
                user.getPassword(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getPhone_number());
    }
}