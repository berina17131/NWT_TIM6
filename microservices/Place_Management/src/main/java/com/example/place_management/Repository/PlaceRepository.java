package com.example.place_management.Repository;

import com.example.place_management.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository  extends JpaRepository<Place, Integer> {
}
