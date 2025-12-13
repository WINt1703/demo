package com.example.demo.mappers;

import com.example.demo.dtos.StatusDto;
import com.example.demo.models.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    Status toEntity(StatusDto statusDto);
    StatusDto fromEntity(Status status);
}
