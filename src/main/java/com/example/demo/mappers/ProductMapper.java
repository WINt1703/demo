package com.example.demo.mappers;

import com.example.demo.dtos.Product.ResponseProductDto;
import com.example.demo.dtos.Product.RequestProductDto;
import com.example.demo.models.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        uses = {UnitTypeMapper.class, CategoryMapper.class, ManufacturerMapper.class, SupplierMapper.class})
public interface ProductMapper {
    @Mapping(target = "quantityInStock", source = "quantity")
    Product toEntity(ResponseProductDto productDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "title", source = "dto.title")
    @Mapping(target = "quantityInStock", source = "dto.quantity")
    @Mapping(target = "unitType", source = "unitType")
    @Mapping(target = "manufacturer", source = "manufacturer")
    @Mapping(target = "supplier", source = "supplier")
    @Mapping(target = "category", source = "category")
    void copyToEntity(@MappingTarget Product product,
                      RequestProductDto dto,
                      UnitType unitType,
                      Category category,
                      Manufacturer manufacturer,
                      Supplier supplier);

    @InheritInverseConfiguration
    ResponseProductDto fromEntity(Product product);
}
