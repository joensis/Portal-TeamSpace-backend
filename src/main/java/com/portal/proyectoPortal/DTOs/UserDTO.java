package com.portal.proyectoPortal.DTOs;


import com.portal.proyectoPortal.entities.Users;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private Integer idUser;
    private String passwordUser;
    private String nameUser;
    private String emailUser;
    private List<String> roles;

    public UserDTO (){

    }
    public UserDTO (Users users){
        this.idUser = users.getIdUser();
        this.nameUser = users.getNameUser();
        this.emailUser = users.getEmailUser();
        this.passwordUser = users.getPasswordUser();
        this.roles = users.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList()); // lo transformamos en un stream (otra lista)
    }

    // GETTERS N SETTERS


    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

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

    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
