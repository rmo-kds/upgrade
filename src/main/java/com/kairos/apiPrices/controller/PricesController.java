package com.kairos.apiPrices.controller;

import com.kairos.apiPrices.dto.PriceInDTO;
import com.kairos.apiPrices.dto.PriceOutDTO;
import com.kairos.apiPrices.mapper.PriceMapper;
import com.kairos.apiPrices.model.Price;
import com.kairos.apiPrices.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
@Api(value = "Prices api")
public class PricesController {

    @Autowired
    private PriceService priceService;

    @ApiOperation(value = "Search prices", notes = "Return the price based on the recibed priceDto")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENT NOT FOUND")})
    @PostMapping(value = "/prices/search")
    public ResponseEntity<PriceOutDTO> search(@RequestBody final PriceInDTO priceDTO) {
        Optional<Price> pricesOpt = Optional
                .ofNullable(priceService.findPriceByQuery(priceDTO))
                .orElseThrow(RuntimeException::new);
        return ResponseEntity.ok().body(PriceMapper.priceToPriceOut(pricesOpt.get()));
    }


}
