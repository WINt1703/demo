package com.example.demo.dtos.Order;

import java.time.LocalDate;
import java.util.Collection;

public record RequestOrderDto(long pickUpPointId,
                              LocalDate createDate,
                              LocalDate deliveryDate,
                              String username,
                              Collection<ProductIdCount> productIdCountCollection) {}
