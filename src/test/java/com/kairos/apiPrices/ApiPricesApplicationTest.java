package com.kairos.apiPrices;

import com.kairos.apiPrices.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApiPricesApplication.class)
@AutoConfigureMockMvc
class ApiPricesApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PriceService priceService;

    //- Test 1: petición a las 10:00 del día 14-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test1() throws Exception {
//		String result =
			mockMvc.perform(post("/api/prices/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"effectiveDate\": \"2020-06-14 10:00:00\",\n" +
                        "  \"idProduct\":35455,\n" +
                        "  \"idBrand\":1\n" +
                        "}"))
                .andExpect(status().isOk())
				.andExpect(jsonPath("$.price", equalTo(35.50)));
//				.andReturn().getResponse().getContentAsString();

    }


    //- Test 2: petición a las 16:00 del día 14-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test2() throws Exception {
//			String result =
			mockMvc.perform(post("/api/prices/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"effectiveDate\": \"2020-06-14 16:00:00\",\n" +
                        "  \"idProduct\":35455,\n" +
                        "  \"idBrand\":1\n" +
                        "}"))
                .andExpect(status().isOk())
				.andExpect(jsonPath("$.price", equalTo(25.45)));
//				.andReturn().getResponse().getContentAsString();
    }

    //- Test 3: petición a las 21:00 del día 14-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test3() throws Exception {
//		String result =
			mockMvc.perform(post("/api/prices/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"effectiveDate\": \"2020-06-14 21:00:00\",\n" +
                        "  \"idProduct\":35455,\n" +
                        "  \"idBrand\":1\n" +
                        "}"))
                .andExpect(status().isOk())
				.andExpect(jsonPath("$.price", equalTo(35.50)));
//				.andReturn().getResponse().getContentAsString();
    }

    //- Test 4: petición a las 10:00 del día 15-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test4() throws Exception {
//		String result =
			mockMvc.perform(post("/api/prices/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"effectiveDate\": \"2020-06-15 10:00:00\",\n" +
                        "  \"idProduct\":35455,\n" +
                        "  \"idBrand\":1\n" +
                        "}"))
                .andExpect(status().isOk())
				.andExpect(jsonPath("$.price", equalTo(30.50)));
//				.andReturn().getResponse().getContentAsString();
    }

    //- Test 5: petición a las 21:00 del día 16-06 del producto 35455   para la brand 1 (ZARA)
    @Test
    void test5() throws Exception {
//		String result =
			mockMvc.perform(post("/api/prices/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"effectiveDate\": \"2020-06-16 21:00:00\",\n" +
                        "  \"idProduct\":35455,\n" +
                        "  \"idBrand\":1\n" +
                        "}"))
                .andExpect(status().isOk())
				.andExpect(jsonPath("$.price", equalTo(38.95)));
//				.andReturn().getResponse().getContentAsString();
    }


    @Test
    void testKO() throws Exception {
//		String result =
        mockMvc.perform(post("/api/prices/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"effectiveDate\": \"2220-06-16 21:00:00\",\n" +
                        "  \"idProduct\":35455,\n" +
                        "  \"idBrand\":1\n" +
                        "}"))
                .andExpect(status().is4xxClientError());
//                .andExpect(jsonPath("$.price", equalTo(38.95)));
//				.andReturn().getResponse().getContentAsString();
    }


}
