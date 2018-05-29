package com.user_managment.ms.Repository;

import com.user_managment.ms.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByPrezime(String prezime);

    Optional<User> findByUsername(String username);

}
