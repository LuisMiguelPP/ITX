package com.luismi.itx.ecommerce.application.adapter;

import com.luismi.itx.ecommerce.application.ports.outbound.PriceOutPort;
import com.luismi.itx.ecommerce.application.service.PriceByDateService;
import com.luismi.itx.ecommerce.domain.model.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PriceByDateServiceTest {

    @Mock
    private PriceOutPort priceOutPort;

    private PriceByDateService priceByDateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceByDateService = new PriceByDateService(priceOutPort);
    }

    @Test
    void getPrice() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 0, 0);
        Integer productId = 35455;
        Long brandId = 1L;

        Price expectedPrice = Price.builder().id(1L).brandId(1L)
                .startDate(applicationDate.minusDays(1))
                .endDate(applicationDate.plusDays(1))
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();

        when(priceOutPort.findPriceByApplicationDateProductIdBrandId(applicationDate, productId, brandId))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> result = priceByDateService.getPrice(applicationDate, productId, brandId);

        assertTrue(result.isPresent());
        assertEquals(expectedPrice, result.get());
    }

    @Test
    void testGetPriceReturnsEmpty() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        Integer productId = 99999;
        Long brandId = 1L;

        when(priceOutPort.findPriceByApplicationDateProductIdBrandId(applicationDate, productId, brandId))
                .thenReturn(Optional.empty());

        Optional<Price> result = priceByDateService.getPrice(applicationDate, productId, brandId);

        assertTrue(result.isEmpty());
    }
}