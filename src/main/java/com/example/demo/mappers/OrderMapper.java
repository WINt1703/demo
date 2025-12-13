package com.example.demo.mappers;

import com.example.demo.dtos.OrderDto;
import com.example.demo.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {StatusMapper.class, PickUpPointMapper.class, ProductMapper.class})
public interface OrderMapper {
    Order toEntity(OrderDto orderDto);
    OrderDto fromEntity(Order order);
}
