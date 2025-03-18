package jp.co.litemo.sm3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import jp.co.litemo.sm3.model.PaymentCondition;
import jp.co.litemo.sm3.repository.PaymentConditionRepository;

/**
 * 支払条件管理のビジネスロジックを実装するサービスクラス
 */
@Service
public class PaymentConditionService {

    @Autowired
    private PaymentConditionRepository paymentConditionRepository;

    /**
     * 支払条件を保存する
     * @param paymentCondition 支払条件エンティティ
     * @return 保存された支払条件
     */
    public PaymentCondition savePaymentCondition(@Valid PaymentCondition paymentCondition) {
        // バリデーションは@Validアノテーションで実施
        return paymentConditionRepository.save(paymentCondition);
    }

    /**
     * IDから支払条件を取得する
     * @param id 支払条件のID
     * @return 支払条件のOptional
     */
    public Optional<PaymentCondition> getPaymentConditionById(Integer id) {
        return paymentConditionRepository.findById(id);
    }

    /**
     * 全ての支払条件を取得する
     * @return 支払条件のリスト
     */
    public List<PaymentCondition> getAllPaymentConditions() {
        return paymentConditionRepository.findAll();
    }

    /**
     * 支払条件を削除する
     * @param id 支払条件のID
     */
    public void deletePaymentCondition(Integer id) {
        paymentConditionRepository.deleteById(id);
    }
}
