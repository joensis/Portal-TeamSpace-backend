package com.portal.proyectoPortal.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_roles")
    private Integer idRoles;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Users> users;




    public Roles() {
    }

    public Roles(String name) {
        this.name = name;
    }

    public int getIdRoles() {
        return idRoles;
    }
    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
