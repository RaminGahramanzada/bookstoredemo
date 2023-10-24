package com.example.bookstoredemo.repository;


import com.example.bookstoredemo.model.ERole;
import com.example.bookstoredemo.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query(value = "select r from Role r where r.roleName =:roleName")
    Optional<Role> findByRoleName(@Param(value = "roleName") ERole role);
}
