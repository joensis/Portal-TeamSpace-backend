package com.portal.proyectoPortal.services;

import com.portal.proyectoPortal.DTOs.LoginRequestDTO;
import com.portal.proyectoPortal.DTOs.LoginResponseDTO;
import com.portal.proyectoPortal.DTOs.UserDTO;
import com.portal.proyectoPortal.entities.Roles;
import com.portal.proyectoPortal.entities.Users;
import com.portal.proyectoPortal.repositories.RoleRespository;
import com.portal.proyectoPortal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRespository roleRespository; // para usar para añadir rol al nuevo usuario

    // PARA HACER LOGIN
    public LoginResponseDTO login (LoginRequestDTO loginRequest){
        Optional<Users> optionalUser = userRepository.findByEmailUser(loginRequest.getEmailUser());

        if (optionalUser.isPresent()){
            Users user = optionalUser.get();

            if (user.getPasswordUser().equals(loginRequest.getPasswordUser())){  //cambiar esto por la encriptacion de la contraseña
                UserDTO userDTO = new UserDTO(user);
                String token = "mock-token"; // aqui debemos generar el token
                return new LoginResponseDTO(token, userDTO);
            }else{
                throw new RuntimeException("Contraseña incorrecta");
            }
        }else{
            throw new RuntimeException("Usuario no encontrado");
        }

    }

    // PARA CREAR USUARIO    //
    public UserDTO registerUsers (UserDTO userDTO){
        Roles defaultRole = roleRespository.findByName("ROLE_USER");  //OBTENEMOS EL ROLE_USER DE LA TABLE ROLES, PORQUE VA A SER EL PREDEFINIDO CUANDO SE CREE UN USUARIO

        //TRANSFORMAMOS EL DTO EN ENTIDAD USER, QUE ES LA QUE MANDAMOS A LA BASE
        Users user = new Users();
        user.setNameUser(userDTO.getNameUser());
        user.setEmailUser(userDTO.getEmailUser());
        user.setPasswordUser(userDTO.getPasswordUser());
        user.setRoles(List.of(defaultRole));

        //GUARDAMOS EN LA BASE DE DATOS
        Users savedUser = userRepository.save(user);


        //DEVOLVEMOS UN DTO TRANSFORMANDO DE NUEVO LA ENTIDAD QUE NOS DEVUELVE UNA VEZ GRABADO EN LA BASE
        return new UserDTO(user);
    }

}
