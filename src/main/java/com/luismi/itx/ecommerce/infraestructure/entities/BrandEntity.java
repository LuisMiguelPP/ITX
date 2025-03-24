package com.luismi.itx.ecommerce.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brand")
public class BrandEntity {
    @Id
    @Column(columnDefinition = "NUMBER", name = "brand_id", nullable = false)
    @GeneratedValue(generator = "BrandSequenceGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "BrandSequenceGen", sequenceName = "BRAND_SEQUENCE", allocationSize = 1)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String brandName;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<PriceEntity> prices;
}
