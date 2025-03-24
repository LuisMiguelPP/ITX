package com.luismi.itx.ecommerce.infraestructure.adapters.outbound;

import com.luismi.itx.ecommerce.domain.model.Price;
import com.luismi.itx.ecommerce.infraestructure.entities.BrandEntity;
import com.luismi.itx.ecommerce.infraestructure.entities.PriceEntity;
import com.luismi.itx.ecommerce.infraestructure.repository.PriceJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PriceRepositoryAdapterTest {

    @Mock
    private PriceJpaRepository priceJpaRepository;

    private PriceRepositoryAdapter priceRepositoryAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceRepositoryAdapter = new PriceRepositoryAdapter(priceJpaRepository);
    }

    @Test
    void testFindApplicablePriceReturnsPrice() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        Integer productId = 35455;
        Long brandId = 1L;

        BrandEntity brandEntity = BrandEntity.builder().id(1L).brandName("ZARA").build();
        PriceEntity priceEntity = PriceEntity.builder()
                .id(1L)
                .brand(brandEntity)
                .startDate(applicationDate.minusDays(1))
                .endDate(applicationDate.plusDays(1))
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();

        Price expectedPrice = Price.builder().id(1L).brandId(1L)
                .startDate(applicationDate.minusDays(1))
                .endDate(applicationDate.plusDays(1))
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();

        when(priceJpaRepository.findPriceByApplicationDateProductIdBrandId(applicationDate, productId, brandId))
                .thenReturn(Optional.of(priceEntity));

        Optional<Price> result = priceRepositoryAdapter.findPriceByApplicationDateProductIdBrandId(applicationDate, productId, brandId);

        assertTrue(result.isPresent());
        assertEquals(expectedPrice.getBrandId(), result.get().getBrandId());
        assertEquals(expectedPrice.getProductId(), result.get().getProductId());
        assertEquals(expectedPrice.getPrice(), result.get().getPrice());
    }

    @Test
    void testFindApplicablePriceReturnsEmpty() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        Integer productId = 99999;
        Long brandId = 1L;

        when(priceJpaRepository.findPriceByApplicationDateProductIdBrandId(applicationDate, productId, brandId))
                .thenReturn(Optional.empty());

        Optional<Price> result = priceRepositoryAdapter.findPriceByApplicationDateProductIdBrandId(applicationDate, productId, brandId);

        assertTrue(result.isEmpty());
    }

}