package com.luismi.itx.ecommerce.infraestructure.adapters.outbound;

import com.luismi.itx.ecommerce.infraestructure.mapper.PriceEntityMapper;
import com.luismi.itx.ecommerce.application.ports.outbound.PriceOutPort;
import com.luismi.itx.ecommerce.domain.model.Price;
import com.luismi.itx.ecommerce.infraestructure.repository.PriceJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryAdapter implements PriceOutPort {

    private final PriceJpaRepository priceJpaRepository;

    public PriceRepositoryAdapter(PriceJpaRepository priceJpaRepository) {
        this.priceJpaRepository = priceJpaRepository;
    }
    @Override
    public Optional<Price> findPriceByApplicationDateProductIdBrandId(LocalDateTime applicationDate, Integer productId, Long brandId) {
        return priceJpaRepository.findPriceByApplicationDateProductIdBrandId(applicationDate, productId, brandId)
                .map(PriceEntityMapper.INSTANCE::toDomain);
    }
}
