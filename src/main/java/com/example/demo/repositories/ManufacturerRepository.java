package com.example.demo.repositories;

import com.example.demo.models.Category;
import com.example.demo.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {}
