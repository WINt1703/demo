package com.example.demo.dtos.Product;

import com.example.demo.dtos.CategoryDto;
import com.example.demo.dtos.ManufacturerDto;
import com.example.demo.dtos.SupplierDto;
import com.example.demo.dtos.UnitTypeDto;

public record ResponseProductDto(
        String id,
        String title,
        String description,
        double cost,
        int maxDiscountAmount,
        int discountAmount,
        int quantity,
        UnitTypeDto unitType,
        CategoryDto category,
        ManufacturerDto manufacturer,
        SupplierDto supplier
) {}

