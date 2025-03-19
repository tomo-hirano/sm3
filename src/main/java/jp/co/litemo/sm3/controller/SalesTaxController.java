package jp.co.litemo.sm3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.litemo.sm3.model.SalesTax;
import jp.co.litemo.sm3.service.SalesTaxService;

/**
 * SalesTaxRateEntry.vbから変換
 * 税率管理のエンドポイントを提供するコントローラークラス
 */
@RestController
@RequestMapping("/api/salestax")
public class SalesTaxController {

    @Autowired
    private SalesTaxService salesTaxService;

    @GetMapping
    public List<SalesTax> getAllSalesTaxes() {
        return salesTaxService.findAll();
    }

    @PostMapping
    public ResponseEntity<SalesTax> createSalesTax(@RequestBody SalesTax salesTax) {
        SalesTax createdSalesTax = salesTaxService.save(salesTax);
        return ResponseEntity.ok(createdSalesTax);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesTax> updateSalesTax(@PathVariable("id") Long id, @RequestBody SalesTax salesTax) {
        SalesTax updatedSalesTax = salesTaxService.update(id, salesTax);
        return ResponseEntity.ok(updatedSalesTax);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesTax(@PathVariable("id") Long id) {
        salesTaxService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
