package com.example.demo.mappers;

import com.example.demo.dtos.SupplierDto;
import com.example.demo.models.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    Supplier toEntity(SupplierDto supplierDto);
    SupplierDto fromEntity(Supplier supplier);
}
