package com.portal.proyectoPortal.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Integer idUser;


    private String nameUser;

    @Column(unique = true, name = "email_user")
    private String emailUser;
    @Column(name = "password_user")
    private String passwordUser;

    @Transient
    private boolean admin;  // esto es para manejar si es admin o user. añadimos @Transient para decir que no es una columna en la bd



    @ManyToMany
    @JoinTable(
            name= "users_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"),
            uniqueConstraints = { @UniqueConstraint(columnNames= {"user_id", "role_id"})}
    )
    private List<Roles> roles;

    public Users() {

    }

    public Users(int idUser, String nameUser, String emailUser, String passwordUser) {
        this.idUser = idUser;
        this.nameUser = nameUser; //
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String toString(){
        return "Id: " + idUser + ", nombre de usuario: " + " nameUser: " + ", email: " + emailUser +
                ", password: " + passwordUser;
    }
}
