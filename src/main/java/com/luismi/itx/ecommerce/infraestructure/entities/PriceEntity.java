package com.luismi.itx.ecommerce.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prices")
public class PriceEntity {

    @Id
    @Column(columnDefinition = "NUMBER", name = "price_id", nullable = false)
    @GeneratedValue(generator = "PriceSequenceGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PriceSequenceGen", sequenceName = "PRICE_SEQUENCE", allocationSize = 1)
    private Long id;

    @JoinColumn(columnDefinition = "NUMBER", name = "brand_id", nullable = false)
    @ManyToOne
    private BrandEntity brand;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "price_list", nullable = false)
    private Integer priceList;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, length = 3)
    private String curr;
}
