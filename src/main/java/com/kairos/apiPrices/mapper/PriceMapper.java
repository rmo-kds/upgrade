package com.kairos.apiPrices.mapper;

import com.kairos.apiPrices.dto.PriceOutDTO;
import com.kairos.apiPrices.model.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PriceMapper {

    public static PriceOutDTO priceToPriceOut(final Price price) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return new PriceOutDTO()
                .setIdBrand(price.getIdBrand())
                .setIdProduct(price.getIdProduct())
                .setIdPrice(price.getIdPrice())
                .setDateIntervalToApply("From " + price.getStartDate().format(dtf)
                        + " to " + price.getEndDate().format(dtf))
                .setPrice(price.getPrice());
    }
}
