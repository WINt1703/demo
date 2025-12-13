package com.example.demo.mappers;

import com.example.demo.dtos.PickUpPointDto;
import com.example.demo.models.PickUpPoint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PickUpPointMapper {
    PickUpPoint toEntity(PickUpPointDto pickUpPointDto);
    PickUpPointDto fromEntity(PickUpPoint pickUpPoint);
}
