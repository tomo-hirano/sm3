package jp.co.litemo.sm3.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * SalesTax.vbから変換
 * 税率を表すエンティティクラス
 */
@Entity
@Table(name = "sales_taxes")
@Getter
@Setter
public class SalesTax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apply_start_date", nullable = false)
    @NotNull(message = "適用開始日は必須です")
    private LocalDate applyStartDate;

    @Column(name = "rate", nullable = false)
    @DecimalMin(value = "0.0", inclusive = true, message = "税率は0%以上でなければなりません")
    @DecimalMax(value = "100.0", inclusive = true, message = "税率は100%以下でなければなりません")
    private BigDecimal taxRate;

    // Getters and Setters
}
