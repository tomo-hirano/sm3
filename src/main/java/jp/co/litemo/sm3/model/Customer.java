package jp.co.litemo.sm3.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 顧客1社を表現するエンティティクラス
 */
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "顧客名は必ず入力が必要です")
    @Size(max = 50, message = "顧客名は50文字以内での入力が必要です")
    @Column(nullable = false, length = 50)
    private String name;

    @NotEmpty(message = "顧客名かなは必ず入力が必要です")
    @Size(max = 50, message = "顧客名かなは50文字以内での入力が必要です")
    @Column(nullable = false, length = 50)
    private String kanaName;

    @NotNull(message = "営業担当者は必ず指定してください")
    @ManyToOne
    @JoinColumn(name = "pic_id", nullable = false)
    private Employee pic;

    @NotNull(message = "支払条件は必ず指定してください")
    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private PaymentCondition paymentCondition;

    @Size(max = 8, message = "郵便番号は8桁で入力してください")
    @Column(length = 8)
    private String postalCode;

    @NotEmpty(message = "住所1は必ず入力してください")
    @Size(max = 50, message = "住所1は50文字以内で入力してください")
    @Column(nullable = false, length = 50)
    private String address1;

    @Size(max = 50, message = "住所2は50文字以内で入力してください")
    @Column(length = 50)
    private String address2;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKanaName() {
        return kanaName;
    }

    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    public Employee getPic() {
        return pic;
    }

    public void setPic(Employee pic) {
        this.pic = pic;
    }

    public PaymentCondition getPaymentCondition() {
        return paymentCondition;
    }

    public void setPaymentCondition(PaymentCondition paymentCondition) {
        this.paymentCondition = paymentCondition;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}