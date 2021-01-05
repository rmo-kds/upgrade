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

    @ApiModelProperty(notes = "Brand id", position = 4)
    private Long idBrand;
    @ApiModelProperty(notes = "Product id", position = 3)
    private Long idProduct;
    @ApiModelProperty(notes = "Final price", position = 1)
    private BigDecimal price;
    @ApiModelProperty(notes = "Price id (Tarifa a aplicar)", position = 0)
    private Long idPrice;
    @ApiModelProperty(notes = "Interval date to apply the price",
            example = "From 2020-12-31 00:00:00 to 2020-12-31 23:59:59"
            , position = 2)
    private String dateIntervalToApply;
}
