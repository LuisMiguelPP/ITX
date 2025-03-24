package com.luismi.itx.ecommerce.infraestructure.mapper;

import com.luismi.itx.ecommerce.domain.model.Price;
import com.luismi.itx.ecommerce.infraestructure.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceEntityMapper {
    PriceEntityMapper INSTANCE = Mappers.getMapper(PriceEntityMapper.class);

    @Mapping(source = "brand.id", target = "brandId")
    Price toDomain(PriceEntity priceEntity);
}
