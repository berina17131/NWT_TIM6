package com.example.event_management.Repository;

import com.example.event_management.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
