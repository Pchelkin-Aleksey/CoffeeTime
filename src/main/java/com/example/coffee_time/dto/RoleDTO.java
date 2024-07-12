package com.example.coffee_time.dto;
import com.example.coffee_time.entity.Role;

public record RoleDTO(
        Long id,
        String named)
{
    public Role toEntity(){
        return new Role(id,named);
    }

    public static RoleDTO fromEntity(Role role){
        return role == null
                ? new RoleDTO(null, null)
                : new RoleDTO(role.getId(), role.getNamed());
    }
}
