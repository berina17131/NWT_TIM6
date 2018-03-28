package com.example.interaction_management.Repository;

import com.example.interaction_management.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
