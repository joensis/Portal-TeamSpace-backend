package com.portal.proyectoPortal.controllers;

import com.portal.proyectoPortal.DTOs.LoginRequestDTO;
import com.portal.proyectoPortal.DTOs.LoginResponseDTO;
import com.portal.proyectoPortal.DTOs.UserDTO;
import com.portal.proyectoPortal.entities.Users;
import com.portal.proyectoPortal.repositories.UserRepository;
import com.portal.proyectoPortal.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")   //permitir conexion desde el origen
@RestController
@RequestMapping("/api/users")
public class UserControler {

    //INYECTAMOS EL SERVICIO
    @Autowired
    private UserServices userService;



    //CREAR USUARIO
    @PostMapping("/register")
    private Map<String, Object> addUsers(@RequestBody UserDTO userDTO) {
        userService.registerUsers(userDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuario creado correctamente");
        return response;
    }

    //HACER LOGIN
    @PostMapping("/login")
    private LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){



        return userService.login(loginRequestDTO);
    }
}