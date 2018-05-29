package com.user_managment.ms.Repository;

import com.user_managment.ms.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRole(String name);
}