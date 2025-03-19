package jp.co.litemo.sm3.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.litemo.sm3.model.SalesTax;

/**
 * SalesTaxRepositoryImpl.vbから変換
 * 税率のデータアクセスを管理するリポジトリインターフェース
 */
@Repository
public interface SalesTaxRepository extends JpaRepository<SalesTax, Long> {

    @Query("SELECT COUNT(s) > 0 FROM SalesTax s WHERE s.applyStartDate = :applyStartDate AND s.id <> :id")
    boolean existsByApplyStartDateAndNotId(@Param("applyStartDate") LocalDate applyStartDate, @Param("id") Long id);
}
