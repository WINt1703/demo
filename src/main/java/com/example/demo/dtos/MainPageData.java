package com.example.demo.dtos;

import com.example.demo.models.*;

import java.util.List;

public record MainPageData(
        List<Product> products,
        List<Supplier> suppliers,
        List<Manufacturer> manufacturers,
        List<Category> categories,
        List<UnitType> unitTypes,
        List<PickUpPoint> pickUpPoints)
{}
