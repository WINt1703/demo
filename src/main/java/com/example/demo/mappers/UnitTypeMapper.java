package com.example.demo.mappers;

import com.example.demo.dtos.UnitTypeDto;
import com.example.demo.models.UnitType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnitTypeMapper {
    UnitType toEntity(UnitTypeDto unitTypeDto);
    UnitTypeDto fromEntity(UnitType unitType);
}
