package com.luismi.itx.ecommerce.infraestructure.adapters.inbound;

import com.luismi.itx.ecommerce.application.ports.inbound.PriceByDatePort;
import com.luismi.itx.ecommerce.domain.model.Price;
import com.luismi.itx.ecommerce.infraestructure.controllers.PriceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PriceByDatePort priceByDatePort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPrice() throws Exception {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
    Integer productId = 35455;
    Long brandId = 1L;

    Price price = Price.builder().id(1L).brandId(1L)
            .startDate(applicationDate.minusDays(1))
            .endDate(applicationDate.plusDays(1))
            .priceList(1)
            .productId(35455)
            .priority(0)
            .price(BigDecimal.valueOf(35.50))
            .curr("EUR")
            .build();

    when(priceByDatePort.getPrice(applicationDate, productId, brandId)).thenReturn(Optional.of(price));

    mockMvc.perform(get("/price")
            .param("applicationDate", "2020-06-14T10:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void testGetPrice_NotFound() throws Exception {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        Integer productId = 99999;
        Long brandId = 1L;

        when(priceByDatePort.getPrice(applicationDate, productId, brandId))
                .thenReturn(Optional.empty());

        mockMvc.perform(get("/price")
                        .param("applicationDate", "2020-06-14T10:00:00")
                        .param("productId", "99999")
                        .param("brandId", "1"))
                .andExpect(status().isNotFound());
    }
}