package com.user_managment.ms.Repository;

import com.user_managment.ms.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByPrezime(String prezime);

    @Query("SELECT ru FROM User ru WHERE username = :username")
    User getByUsername(@Param("username") String username);
}
