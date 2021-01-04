package com.kairos.apiPrices.service;

import com.kairos.apiPrices.dto.PriceInDTO;
import com.kairos.apiPrices.model.Price;

import java.util.Optional;


public interface PriceService {
    Optional<Price> findPriceByQuery(PriceInDTO priceDTO) ;
}
