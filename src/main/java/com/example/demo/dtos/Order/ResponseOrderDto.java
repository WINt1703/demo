package com.example.demo.dtos.Order;

import com.example.demo.dtos.PickUpPointDto;
import com.example.demo.dtos.Product.ResponseProductDto;
import com.example.demo.models.Status;

import java.time.LocalDate;
import java.util.Collection;

public record ResponseOrderDto(long id,
                               Status status,
                               PickUpPointDto pickUpPoint,
                               LocalDate createDate,
                               LocalDate deliveryDate,
                               String username,
                               int getCode,
                               Collection<ResponseProductDto> products
) {}
