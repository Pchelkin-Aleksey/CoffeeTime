package com.example.coffee_time.dto;

import com.example.coffee_time.entity.Role;
import com.example.coffee_time.entity.User;

public record UserFormDTO(
        Long id,
        RoleDTO roles,
        String username,
        String confirmPassword,
        String password,
        String first_name,
        String last_name,
        String email,
        String phone_number) {
    public User toEntity() {
        Role role = new Role();
        Long roleId = this.roles != null
                ? this.roles.id()
                : null;
        String roleName = this.roles != null
                ? this.roles.named()
                : null;
        role.setId(roleId);
        role.setNamed(roleName);

        User user = new User();
        user.setId(this.id);
        user.setRole(role);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setFirst_name(this.first_name);
        user.setLast_name(this.last_name);
        user.setEmail(this.email);
        user.setPhone_number(this.phone_number);
        return user;
    }

    public static UserFormDTO toUserFormDto(User user) {
        return new UserFormDTO(
                user.getId(),
                RoleDTO.fromEntity(user.getRole()),
                user.getUsername(),
                "",
                "",
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getPhone_number()
        );
    }
}
