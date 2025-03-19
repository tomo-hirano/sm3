package jp.co.litemo.sm3.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jp.co.litemo.sm3.model.SalesTax;

@DataJpaTest
class SalesTaxRepositoryTest {

    @Autowired
    private SalesTaxRepository salesTaxRepository;

    @Test
    void testSaveAndFindById() {
        SalesTax salesTax = new SalesTax();
        salesTax.setApplyStartDate(LocalDate.now());
        salesTax.setTaxRate(BigDecimal.valueOf(10));

        SalesTax savedSalesTax = salesTaxRepository.save(salesTax);
        Optional<SalesTax> foundSalesTax = salesTaxRepository.findById(savedSalesTax.getId());

        assertTrue(foundSalesTax.isPresent());
        assertEquals(savedSalesTax.getApplyStartDate(), foundSalesTax.get().getApplyStartDate());
        assertEquals(savedSalesTax.getTaxRate(), foundSalesTax.get().getTaxRate());
    }
}
