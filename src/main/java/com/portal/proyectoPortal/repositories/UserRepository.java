package com.portal.proyectoPortal.repositories;

import com.portal.proyectoPortal.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    Optional<Users> findByEmailUser(String emailUser);

}
