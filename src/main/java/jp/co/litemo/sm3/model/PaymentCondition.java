package jp.co.litemo.sm3.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払条件1種類を表現する 変換元ファイル: /Domain/DomainObject/PaymentCondition.vb 変換概要: Java
 * Springのエンティティとバリデーションアノテーションを使用して実装
 */
@Entity
@Table(name = "payment_conditions")
@Getter
@Setter
public class PaymentCondition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "支払条件名は必ず入力しなければなりません")
	@Size(max = 20, message = "支払条件名は20文字以内でなければなりません")
	private String name;

	@Min(value = 1, message = "支払日は1～28以内でなければなりません")
	@Max(value = 28, message = "支払日は1～28以内でなければなりません")
	private Integer dueDate;

	@Min(value = 0, message = "支払月は0～12以内でなければなりません")
	@Max(value = 12, message = "支払月は0～12以内でなければなりません")
	private Integer monthOffset;

	@Min(value = 1, message = "締日は1～28以内でなければなりません")
	@Max(value = 28, message = "締日は1～28以内でなければなりません")
	private Integer cutOff;

	public PaymentCondition() {
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentCondition)) return false;
        PaymentCondition that = (PaymentCondition) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
