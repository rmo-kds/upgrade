package com.kairos.apiPrices.repository;


import com.kairos.apiPrices.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    @Query("select p from Price p where :effectiveDate>=p.startDate and :effectiveDate <= p.endDate " +
            "and p.idProduct= :idProduct and p.idBrand= :idBrand and p.priority = (select max(p.priority) from Price p " +
            "where :effectiveDate>=p.startDate and :effectiveDate <= p.endDate and p.idProduct= :idProduct " +
            "and p.idBrand= :idBrand)")
    public Optional<Price> findPricesByCustomQuery(
            @Param("effectiveDate") final LocalDateTime effectiveDate, @Param("idProduct") final Long idProduct,
            @Param("idBrand") final Long idBrand);
}
