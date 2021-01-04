package com.kairos.apiPrices.unit;

import com.kairos.apiPrices.dto.PriceInDTO;
import com.kairos.apiPrices.model.Price;
import com.kairos.apiPrices.repository.PriceRepository;
import com.kairos.apiPrices.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class PriceServiceTest {

    @Autowired
    private PriceService priceService;

    @MockBean
    private PriceRepository priceRepository;

    @Test
    public void test(){

        Price priceDB = new Price().setPrice(BigDecimal.valueOf(55.55));
        when(priceRepository.findPricesByCustomQuery(any(), any(), any()))
                .thenReturn(Optional.of(priceDB));

        PriceInDTO inDTO = new PriceInDTO()
                .setEffectiveDate(LocalDateTime.now())
                .setIdBrand(1L).setIdProduct(35455L);
        Optional<Price> restultado = priceService.findPriceByQuery(inDTO);
        assertThat(restultado.get().getPrice()).isEqualTo(BigDecimal.valueOf(55.55));
    }
}
