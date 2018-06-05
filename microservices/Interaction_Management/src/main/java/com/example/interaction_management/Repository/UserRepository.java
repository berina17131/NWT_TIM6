package com.example.interaction_management.Repository;

import com.example.interaction_management.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query(value = "INSERT INTO user (id, username) VALUES (:id, :username)", nativeQuery = true)
    @Transactional
    void saveUser(@Param("id") int id, @Param("username") String username);

    @Modifying
    @Query(value = "UPDATE user SET username=:username WHERE id=:id", nativeQuery = true)
    @Transactional
    void changeUser(@Param("id") int id, @Param("username") String username);

    Optional<User> findByUsername(String username);
}
