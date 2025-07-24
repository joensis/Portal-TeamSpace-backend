package com.portal.proyectoPortal.DTOs;

import com.portal.proyectoPortal.entities.Users;

public class LoginResponseDTO {

    private String message;
    private UserDTO userDTO;

    public LoginResponseDTO(){

    }

    public LoginResponseDTO(String message, UserDTO userDTO) {
        this.message = message;
        this.userDTO = userDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
