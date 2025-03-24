package com.luismi.itx.ecommerce.infraestructure.mapper;

import com.luismi.itx.ecommerce.domain.model.Price;
import com.luismi.itx.ecommerce.infraestructure.adapters.dto.PriceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    PriceResponseDTO toDto(Price price);
}
