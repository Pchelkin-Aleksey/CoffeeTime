package com.example.coffee_time.controller;

import com.example.coffee_time.dto.RoleDTO;
import com.example.coffee_time.dto.UserDTO;
import com.example.coffee_time.dto.UserFormDTO;
import com.example.coffee_time.entity.User;
import com.example.coffee_time.service.RolesService;
import com.example.coffee_time.service.UserService;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/users")
@Data
public class UserController {

    private final UserService userService;
    private final RolesService rolesService;

    @GetMapping
    public String getUsers(Model model) {
        List<UserDTO> users = userService.findAll()
                .stream()
                .map(UserDTO::toDto)
                .toList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        List<RoleDTO> roles = rolesService.findAll()
                .stream()
                .map(RoleDTO::fromEntity)
                .toList();
        model.addAttribute("user",user);
        model.addAttribute("roles", roles);
        return "user/form";
    }

    @GetMapping("new")
    public String newUser(Model model){
        List<RoleDTO> roles = rolesService.findAll()
                .stream()
                .map(RoleDTO::fromEntity)
                .toList();
        model.addAttribute("user", UserFormDTO.toUserFormDto(new User()));
        model.addAttribute("roles", roles);
        return "user/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UserFormDTO user) {
        userService.saveUser(user.toEntity());
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}