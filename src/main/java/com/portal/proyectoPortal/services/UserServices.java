package com.portal.proyectoPortal.services;

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
    public Users login (String email, String password){
        Optional<Users> optionalUser = userRepository.findByEmailUser(email);

        if (optionalUser.isPresent()){
            Users user = optionalUser.get();

            if (user.getPasswordUser().equals(password)){  //cambiar esto por la encriptacion de la contraseña
                return user;
            }else{
                return null; //cambiar esto por un mensaje que diga que no coincide la contraseña
            }
        }else{
            return null; //cambiar esto por un mensaje que diga que no se encuentra el email.
        }

    }

    // PARA CREAR USUARIO
    public Users registerUsers (Users user){
        Roles defaultRole = roleRespository.findByName("ROLE_USER");  //OBTENEMOS EL ROLE_USER DE LA TABLE ROLES, PORQUE VA A SER EL PREDEFINIDO CUANDO SE CREE UN USUARIO

        user.setRoles(List.of(defaultRole));                    //AÑADIMOS EL ROL USER_ROLE A TODOS LOS USUARIOS QUE SE CREEN
        //AQUI PODEMOS AÑADIR OTRAS COMPROBACIONES COMO QUE EL EMAIL NO EXISTA YA...
        return userRepository.save(user);
    }

}
