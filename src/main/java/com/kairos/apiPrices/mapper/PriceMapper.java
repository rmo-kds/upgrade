package com.kairos.apiPrices.mapper;

import com.kairos.apiPrices.dto.PriceOutDTO;
import com.kairos.apiPrices.model.Price;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@ApiModel(description = "Price Out Data Transfer Object class")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PriceMapper {

	public static PriceOutDTO priceOutToPrice(final Price price) {
		return new PriceOutDTO()
				.setIdBrand(price.getIdBrand())
				.setIdProduct(price.getIdProduct())
				.setIdPrice(price.getIdPrice())
				.setStartDate(price.getStartDate())
				.setEndDate(price.getEndDate())
				.setPrice(price.getPrice());
	}
}
