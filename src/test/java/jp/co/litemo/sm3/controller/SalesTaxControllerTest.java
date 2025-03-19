package jp.co.litemo.sm3.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.litemo.sm3.model.SalesTax;
import jp.co.litemo.sm3.service.SalesTaxService;

class SalesTaxControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SalesTaxService salesTaxService;

    @InjectMocks
    private SalesTaxController salesTaxController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(salesTaxController).build();
    }

    @Test
    void testGetAllSalesTaxes() throws Exception {
        when(salesTaxService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/salestax"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());

        verify(salesTaxService, times(1)).findAll();
    }

    @Test
    void testCreateSalesTax() throws Exception {
        SalesTax salesTax = new SalesTax();
        salesTax.setApplyStartDate(LocalDate.now());
        salesTax.setTaxRate(BigDecimal.valueOf(10));

        when(salesTaxService.save(any(SalesTax.class))).thenReturn(salesTax);

        mockMvc.perform(post("/api/salestax")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"applyStartDate\":\"2023-01-01\",\"taxRate\":10}"))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.applyStartDate").value("2023-01-01"))
                .andExpect(jsonPath("$.taxRate").value(10));

        verify(salesTaxService, times(1)).save(any(SalesTax.class));
    }
}
