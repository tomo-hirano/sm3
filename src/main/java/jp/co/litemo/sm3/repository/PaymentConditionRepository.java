package jp.co.litemo.sm3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.litemo.sm3.model.PaymentCondition;

/**
 * 支払条件永続化のためのリポジトリインターフェース
 */
@Repository
public interface PaymentConditionRepository extends JpaRepository<PaymentCondition, Integer> {

    /**
     * 支払条件名からモデルオブジェクトを取得
     * @param name 支払条件名
     * @return 支払条件のOptional
     */
    Optional<PaymentCondition> findByName(String name);

    /**
     * 登録済みのすべての支払条件モデルオブジェクトを取得
     * @return 支払条件のリスト
     */
    List<PaymentCondition> findAll();

    /**
     * 引数の条件を満たしたすべての支払条件を取得
     * @param cond 支払条件の検索条件
     * @return 支払条件のリスト
     */
    // Note: This method requires a custom implementation if complex conditions are needed
    // List<PaymentCondition> findByCondition(PaymentConditionRepositorySearchCondition cond);

    /**
     * 登録されている支払条件数を取得する
     * @return 支払条件の数
     */
    long count();
}
