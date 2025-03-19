package jp.co.litemo.sm3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import jp.co.litemo.sm3.model.SalesTax;
import jp.co.litemo.sm3.repository.SalesTaxRepository;

/**
 * SalesTaxRateEntry.vbから変換
 * 税率のビジネスロジックを実装するサービスクラス
 */
@Service
public class SalesTaxService {

    @Autowired
    private SalesTaxRepository salesTaxRepository;

    public List<SalesTax> findAll() {
        return salesTaxRepository.findAll();
    }

    public SalesTax save(@Valid SalesTax salesTax) {
        if (salesTaxRepository.existsByApplyStartDateAndNotId(salesTax.getApplyStartDate(), salesTax.getId())) {
            throw new IllegalArgumentException("適用開始日は重複しています");
        }
        return salesTaxRepository.save(salesTax);
    }

    public SalesTax update(Long id, @Valid SalesTax salesTax) {
        salesTax.setId(id);
        return save(salesTax);
    }

    public void delete(Long id) {
        salesTaxRepository.deleteById(id);
    }
}
