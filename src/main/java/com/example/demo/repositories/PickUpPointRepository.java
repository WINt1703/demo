package com.example.demo.repositories;

import com.example.demo.models.PickUpPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickUpPointRepository extends JpaRepository<PickUpPoint, Long> {
}
