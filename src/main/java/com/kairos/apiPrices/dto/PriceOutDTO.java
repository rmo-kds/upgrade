package com.kairos.apiPrices.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "Price In Data Transfer Object class")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PriceOutDTO {
    @ApiModelProperty(notes = "idBrand")
    private Long idBrand;
    @ApiModelProperty(notes = "idProduct")
    private Long idProduct;
    @ApiModelProperty(notes = "price")
	private BigDecimal price;
    @ApiModelProperty(notes = "idPrice")
    private Long idPrice;
	@ApiModelProperty(notes = "startDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startDate;
	@ApiModelProperty(notes = "endDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endDate;
}
