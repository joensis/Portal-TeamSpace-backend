package com.portal.proyectoPortal.controllers;

import com.portal.proyectoPortal.entities.Users;
import com.portal.proyectoPortal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")   //permitir conexion desde el origen
@RestController
@RequestMapping("/api/users")
public class UserControler {

    //inyectamos la interfaz
    @Autowired
    private UserRepository userRepository;

    //crear usuario
    @PostMapping("/register")
    private Map<String, Object> addUsers(@RequestBody Users user) {
        userRepository.save(user);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuario creado correctamente");
        return response;
    }
}