package com.kairos.apiPrices.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@ApiModel(description = "PriceOut Data Transfer Object class")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PriceOutDTO {

    @ApiModelProperty(notes = "Brand id")
    private Long idBrand;
    @ApiModelProperty(notes = "Product id")
    private Long idProduct;
    @ApiModelProperty(notes = "Final price")
    private BigDecimal price;
    @ApiModelProperty(notes = "Price id (Tarifa a aplicar)")
    private Long idPrice;
    @ApiModelProperty(notes = "Interval date to apply the price")
    private String dateIntervalToApply;
}
