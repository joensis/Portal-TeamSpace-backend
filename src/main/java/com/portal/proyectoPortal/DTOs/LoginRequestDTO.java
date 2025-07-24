package com.portal.proyectoPortal.DTOs;

import com.portal.proyectoPortal.entities.Users;

public class LoginRequestDTO {

    private String emailUser;
    private String passwordUser;

    public LoginRequestDTO(){

    }
    public LoginRequestDTO (Users users){

        this.emailUser = users.getEmailUser();
        this.passwordUser = users.getPasswordUser();
    }

    // GETTER N SETTER

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}
