package com.luismi.itx.ecommerce.infraestructure.controllers;

import com.luismi.itx.ecommerce.application.ports.inbound.PriceByDatePort;
import com.luismi.itx.ecommerce.domain.model.Price;
import com.luismi.itx.ecommerce.infraestructure.adapters.dto.PriceResponseDTO;
import com.luismi.itx.ecommerce.infraestructure.mapper.PriceMapper;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/price")
public class PriceController {
    private final PriceByDatePort priceByDatePort;

    @GetMapping
    public ResponseEntity<Object> getPrice(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam Integer productId,
            @RequestParam Long brandId) {

        Optional<Price> price = priceByDatePort.getPrice(applicationDate, productId, brandId);

        if(price.isPresent()){
            Optional<PriceResponseDTO> priceResponseDTO = price.map(PriceMapper.INSTANCE::toDto);
            return ResponseEntity.ok(priceResponseDTO);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ErrorResponse.builder()
                            .message("No se encontró ninguna tarifa aplicable.")
                            .build());
        }
    }
}
