package com.luismi.itx.ecommerce.application.ports.inbound;

import com.luismi.itx.ecommerce.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceByDatePort {
    Optional<Price> getPrice(LocalDateTime applicationDate, Integer productId, Long brandId);
}
