package com.luismi.itx.ecommerce.application.service;

import com.luismi.itx.ecommerce.application.ports.inbound.PriceByDatePort;
import com.luismi.itx.ecommerce.application.ports.outbound.PriceOutPort;
import com.luismi.itx.ecommerce.domain.model.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PriceByDateService implements PriceByDatePort {

    private final PriceOutPort priceOutPort;

    @Override
    public Optional<Price> getPrice(LocalDateTime applicationDate, Integer productId, Long brandId) {
        return priceOutPort.findPriceByApplicationDateProductIdBrandId(applicationDate, productId, brandId);
    }
}
