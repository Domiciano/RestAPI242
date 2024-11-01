package com.example.intregradorapi.repository;

import com.example.intregradorapi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//CRUD para entidad
//C: create, R: read, U:update, D:delete
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByEmailAndPassword(String email, String password);
}
