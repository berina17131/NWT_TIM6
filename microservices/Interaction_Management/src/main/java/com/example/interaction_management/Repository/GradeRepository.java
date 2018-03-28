package com.example.interaction_management.Repository;

import com.example.interaction_management.Model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
