package com.kairos.apiPrices.controller;

import com.kairos.apiPrices.dto.PriceInDTO;
import com.kairos.apiPrices.dto.PriceOutDTO;

import com.kairos.apiPrices.mapper.PriceMapper;
import com.kairos.apiPrices.model.Price;
import com.kairos.apiPrices.repository.PriceRepository;
import com.kairos.apiPrices.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
@Api(value = "Prices api")
public class PricesController {

    @Autowired
    private PriceService priceService;


    @ApiOperation(value = "Search prices")
    @PostMapping(value="/prices/search")
    public ResponseEntity<PriceOutDTO> search(@RequestBody PriceInDTO priceDTO) {
        Optional<Price> pricesOpt = Optional
                .ofNullable(priceService.findPriceByQuery(priceDTO))
                .orElseThrow(RuntimeException::new);
        return ResponseEntity.ok().body(PriceMapper.priceOutToPrice(pricesOpt.get()));
    }









}
