package com.example.demo.dtos;

import com.example.demo.dtos.Product.ResponseProductDto;

import java.time.LocalDate;
import java.util.Collection;

public record OrderDto(long id,
                       StatusDto statusDto,
                       PickUpPointDto pickUpPoint,
                       LocalDate createDate,
                       LocalDate deliveryDate,
                       String username,
                       int getCode,
                       Collection<ResponseProductDto> products
) {}
