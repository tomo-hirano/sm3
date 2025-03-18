package jp.co.litemo.sm3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.litemo.sm3.model.PaymentCondition;
import jp.co.litemo.sm3.service.PaymentConditionService;

/**
 * 支払条件管理のHTTPリクエストを処理するコントローラークラス
 */
@RestController
@RequestMapping("/api/payment-conditions")
public class PaymentConditionController {

    @Autowired
    private PaymentConditionService paymentConditionService;

    /**
     * 全ての支払条件を取得するエンドポイント
     * @return 支払条件のリスト
     */
    @GetMapping
    public ResponseEntity<List<PaymentCondition>> getAllPaymentConditions() {
        List<PaymentCondition> paymentConditions = paymentConditionService.getAllPaymentConditions();
        return ResponseEntity.ok(paymentConditions);
    }

    /**
     * IDから支払条件を取得するエンドポイント
     * @param id 支払条件のID
     * @return 支払条件
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentCondition> getPaymentConditionById(@PathVariable("id") Integer id) {
        Optional<PaymentCondition> paymentCondition = paymentConditionService.getPaymentConditionById(id);
        return paymentCondition.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * 新しい支払条件を作成するエンドポイント
     * @param paymentCondition 支払条件エンティティ
     * @return 作成された支払条件
     */
    @PostMapping
    public ResponseEntity<PaymentCondition> createPaymentCondition(@RequestBody PaymentCondition paymentCondition) {
        PaymentCondition createdPaymentCondition = paymentConditionService.savePaymentCondition(paymentCondition);
        return ResponseEntity.ok(createdPaymentCondition);
    }

    /**
     * 支払条件を削除するエンドポイント
     * @param id 支払条件のID
     * @return 削除結果
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentCondition(@PathVariable("id") Integer id) {
        paymentConditionService.deletePaymentCondition(id);
        return ResponseEntity.noContent().build();
    }
}
