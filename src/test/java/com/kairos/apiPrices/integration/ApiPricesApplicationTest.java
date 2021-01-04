package com.kairos.apiPrices.integration;

import com.kairos.apiPrices.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiPricesApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PriceService priceService;

    //- Test 1: petición a las 10:00 del día 14-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test1() throws Exception {
        mockMvc.perform(post("/api/prices/search")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"effectiveDate\": \"2020-06-14 10:00:00\",\n" +
                    "  \"idProduct\":35455,\n" +
                    "  \"idBrand\":1\n" +
                    "}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price", equalTo(35.50)));
    }

    //- Test 2: petición a las 16:00 del día 14-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test2() throws Exception {
        mockMvc.perform(post("/api/prices/search")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"effectiveDate\": \"2020-06-14 16:00:00\",\n" +
                    "  \"idProduct\":35455,\n" +
                    "  \"idBrand\":1\n" +
                    "}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price", equalTo(25.45)));
    }

    //- Test 3: petición a las 21:00 del día 14-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test3() throws Exception {
        mockMvc.perform(post("/api/prices/search")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"effectiveDate\": \"2020-06-14 21:00:00\",\n" +
                    "  \"idProduct\":35455,\n" +
                    "  \"idBrand\":1\n" +
                    "}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price", equalTo(35.50)));
    }

    //- Test 4: petición a las 10:00 del día 15-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test4() throws Exception {
        mockMvc.perform(post("/api/prices/search")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"effectiveDate\": \"2020-06-15 10:00:00\",\n" +
                    "  \"idProduct\":35455,\n" +
                    "  \"idBrand\":1\n" +
                    "}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price", equalTo(30.50)));
    }

    //- Test 5: petición a las 21:00 del día 16-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test5() throws Exception {
        mockMvc.perform(post("/api/prices/search")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"effectiveDate\": \"2020-06-16 21:00:00\",\n" +
                    "  \"idProduct\":35455,\n" +
                    "  \"idBrand\":1\n" +
                    "}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price", equalTo(38.95)));
    }

    @Test
    void testNotFound() throws Exception {
        mockMvc.perform(post("/api/prices/search")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"effectiveDate\": \"2220-06-16 21:00:00\",\n" +
                    "  \"idProduct\":35400,\n" +
                    "  \"idBrand\":1\n" +
                    "}"))
            .andExpect(status().isNotFound());
    }

}
