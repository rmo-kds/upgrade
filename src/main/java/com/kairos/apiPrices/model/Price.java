package com.kairos.apiPrices.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@ApiModel(description = "Price JPA Entity class")
@Entity
@Table(name = "PRICES")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Price implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_LIST")
    private Long idPrice;
    @Column(name = "BRAND_ID")
    private Long idBrand;
    @Column(name = "PRODUCT_ID")
    private Long idProduct;
    @Column(name = "PRIORITY")
    private Integer priority;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "CURR")
    private String currency;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

}
