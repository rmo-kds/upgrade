package com.kairos.apiPrices.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@ApiModel(description = "Price In Data Transfer Object class")
@Getter 
@Setter 
@Accessors(chain = true)
@NoArgsConstructor
public class PriceInDTO {

	@ApiModelProperty(notes = "idBrand")
	private Long idBrand;
	@ApiModelProperty(notes = "idProduct")
	private Long idProduct;
	@ApiModelProperty(notes = "priority")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime effectiveDate;

}
