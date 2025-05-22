package com.portal.proyectoPortal.repositories;

import com.portal.proyectoPortal.entities.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRespository extends CrudRepository<Roles, Integer> {
    Roles findByName( String name);

}
