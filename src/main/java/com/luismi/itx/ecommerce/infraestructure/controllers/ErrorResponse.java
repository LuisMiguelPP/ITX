package com.luismi.itx.ecommerce.infraestructure.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
}
