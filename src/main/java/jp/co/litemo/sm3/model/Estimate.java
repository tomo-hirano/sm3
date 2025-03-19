package jp.co.litemo.sm3.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estimates")
@Getter
@Setter
public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "見積番号は必ず入力が必要です")
    @Size(max = 20, message = "見積番号は20文字以内で入力してください")
    private String estimateNo;

    @NotNull(message = "顧客は必ず入力が必要です")
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotBlank(message = "件名は必ず入力が必要です")
    @Size(max = 50, message = "件名は50文字以内で入力してください")
    private String title;

    @FutureOrPresent(message = "納期は作成日より前には設定できません")
    private Date dueDate;

    @NotNull(message = "支払条件は必ず入力してください")
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentCondition paymentCondition;

    @NotNull(message = "担当従業員は必ず入力してください")
    @ManyToOne
    @JoinColumn(name = "pic_employee_id")
    private Employee picEmployee;

    @FutureOrPresent(message = "見積有効期限は作成日より前には設定できません")
    private Date effectiveDate;

    @NotNull(message = "消費税は必ず入力してください")
    @ManyToOne
    @JoinColumn(name = "apply_tax_id")
    private SalesTax salesTax;

    private Date issueDate;

    @Size(max = 500, message = "備考は500文字以内で入力してください")
    private String remarks;

    @OneToMany(mappedBy = "estimate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstimateDetail> details;

    // Getters and Setters
}
