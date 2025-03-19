package jp.co.litemo.sm3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estimate_details")
@Getter
@Setter
public class EstimateDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "明細表示順は0から20の範囲で指定してください")
    @Min(value = 0, message = "明細表示順は0から20の範囲で指定してください")
    @Max(value = 20, message = "明細表示順は0から20の範囲で指定してください")
    private Integer displayOrder;

    @NotBlank(message = "品名は必ず入力してください")
    @Size(max = 50, message = "品名は50文字以内で入力してください")
    private String itemName;

    @NotNull(message = "数量は1から999の範囲で指定してください")
    @Min(value = 1, message = "数量は1から999の範囲で指定してください")
    @Max(value = 999, message = "数量は1から999の範囲で指定してください")
    private Integer quantity;

    @NotNull(message = "単価は0から99999999の範囲で指定してください")
    @DecimalMin(value = "0.0", inclusive = true, message = "単価は0から99999999の範囲で指定してください")
    @DecimalMax(value = "99999999.0", inclusive = true, message = "単価は0から99999999の範囲で指定してください")
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "estimate_id")
    private Estimate estimate;

    // Getters and Setters
}
