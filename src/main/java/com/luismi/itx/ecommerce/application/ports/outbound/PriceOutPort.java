package com.luismi.itx.ecommerce.application.ports.outbound;

import com.luismi.itx.ecommerce.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceOutPort {
    Optional<Price> findPriceByApplicationDateProductIdBrandId(LocalDateTime applicationDate, Integer productId, Long brandId);
}
