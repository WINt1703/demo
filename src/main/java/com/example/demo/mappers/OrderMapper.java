package com.example.demo.mappers;

import com.example.demo.dtos.Order.RequestOrderDto;
import com.example.demo.dtos.Order.ResponseOrderDto;
import com.example.demo.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {PickUpPointMapper.class, ProductMapper.class})
public interface OrderMapper {
    Order toEntity(ResponseOrderDto orderDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pickUpPoint", source = "pickUpPoint")
    void copyToEntity(@MappingTarget Order product,
                      RequestOrderDto dto,
                      PickUpPoint pickUpPoint);

    ResponseOrderDto fromEntity(Order order);
}
