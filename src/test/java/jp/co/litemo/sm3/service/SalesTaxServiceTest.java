package jp.co.litemo.sm3.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jp.co.litemo.sm3.model.SalesTax;
import jp.co.litemo.sm3.repository.SalesTaxRepository;

class SalesTaxServiceTest {

    @Mock
    private SalesTaxRepository salesTaxRepository;

    @InjectMocks
    private SalesTaxService salesTaxService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        when(salesTaxRepository.findAll()).thenReturn(Collections.emptyList());

        List<SalesTax> salesTaxes = salesTaxService.findAll();

        assertNotNull(salesTaxes);
        assertTrue(salesTaxes.isEmpty());
        verify(salesTaxRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        SalesTax salesTax = new SalesTax();
        salesTax.setApplyStartDate(LocalDate.now());
        salesTax.setTaxRate(BigDecimal.valueOf(10));

        when(salesTaxRepository.save(any(SalesTax.class))).thenReturn(salesTax);

        SalesTax savedSalesTax = salesTaxService.save(salesTax);

        assertNotNull(savedSalesTax);
        assertEquals(salesTax.getApplyStartDate(), savedSalesTax.getApplyStartDate());
        assertEquals(salesTax.getTaxRate(), savedSalesTax.getTaxRate());
        verify(salesTaxRepository, times(1)).save(salesTax);
    }
}
