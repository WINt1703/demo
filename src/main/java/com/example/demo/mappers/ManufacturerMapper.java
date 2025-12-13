package com.example.demo.mappers;

import com.example.demo.dtos.ManufacturerDto;
import com.example.demo.models.Manufacturer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    Manufacturer toEntity(ManufacturerDto manufacturerDto);
    ManufacturerDto fromEntity(Manufacturer manufacturer);
}
