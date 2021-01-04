package com.kairos.apiPrices.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@ApiModel(description = "PriceIn Data Transfer Object class")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PriceInDTO {

    @ApiModelProperty(notes = "Brand id")
    private Long idBrand;
    @ApiModelProperty(notes = "Product id")
    private Long idProduct;
    @ApiModelProperty(notes = "Application date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;

}
