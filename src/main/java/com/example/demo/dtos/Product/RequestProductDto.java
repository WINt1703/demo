package com.example.demo.dtos.Product;

public record RequestProductDto(String title,
                                String description,
                                double cost,
                                int maxDiscountAmount,
                                int discountAmount,
                                int quantity,
                                long unitTypeId,
                                long categoryId,
                                long manufacturerId,
                                long supplierId) {}