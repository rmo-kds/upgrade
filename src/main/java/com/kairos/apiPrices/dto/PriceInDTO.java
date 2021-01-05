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

    @ApiModelProperty(notes = "Brand id", position = 2)
    private Long idBrand;
    @ApiModelProperty(notes = "Product id", position = 1)
    private Long idProduct;
    @ApiModelProperty(notes = "Application date", example = "2020-12-31 23:59:59", position = 0)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;

}
