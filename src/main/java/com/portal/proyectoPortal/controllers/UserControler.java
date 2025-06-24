package com.portal.proyectoPortal.controllers;

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
    private Map<String, Object> addUsers(@RequestBody Users user) {
        userService.registerUsers(user);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuario creado correctamente");
        return response;
    }

    //HACER LOGIN
    @PostMapping("/login")
    private Map<String, Object> login(@RequestBody Map<String, String> loginData){

        String email = loginData.get("email");
        String password = loginData.get("password");

        Users user = userService.login(email, password);

        Map<String, Object> response = new HashMap<>();
        if(user != null){
            response.put("message", "Login correcto");
            response.put("user", user);
        }else{
            response.put("message", "Credenciales incorrectas");
        }
        return response; 
    }
}