package com.luismi.itx.ecommerce.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Price {
    private Long id;
    private Long brandId; // Mapeo del ID de la entidad BrandEntity
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private BigDecimal price;
    private String curr;
}
