package com.kairos.apiPrices.service;

import com.kairos.apiPrices.dto.PriceInDTO;
import com.kairos.apiPrices.model.Price;
import com.kairos.apiPrices.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Optional<Price> findPriceByQuery(final PriceInDTO priceDTO) {
        return priceRepository.findPricesByCustomQuery(priceDTO.getEffectiveDate(),
                priceDTO.getIdProduct(), priceDTO.getIdBrand());
    }
}
