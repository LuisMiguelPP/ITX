package com.luismi.itx.ecommerce.infraestructure.repository;

import com.luismi.itx.ecommerce.infraestructure.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("""
            SELECT p
            FROM PriceEntity p
            WHERE p.productId = :productId
                AND p.brand.id = :brandId
                AND p.startDate <= :applicationDate
                AND p.endDate >= :applicationDate
            ORDER BY p.priority DESC
            LIMIT 1""")
    Optional<PriceEntity> findPriceByApplicationDateProductIdBrandId(LocalDateTime applicationDate, Integer productId, Long brandId);
}
