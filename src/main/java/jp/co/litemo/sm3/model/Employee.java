package jp.co.litemo.sm3.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 元のファイル名: /Domain/DomainObject/Employee.vb
 * このクラスは従業員情報を表すエンティティクラスです。
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_number", nullable = false, length = 5)
    @NotNull(message = "従業員Noは必ず入力してください")
    @Size(max = 5, message = "従業員Noは5文字以内で指定してください")
    private String employeeNo;

    @Column(name = "name", nullable = false, length = 20)
    @NotNull(message = "従業員名は必ず入力してください")
    @Size(max = 20, message = "従業員名は20文字以内で指定してください")
    private String name;

    @Column(name = "name_kana", length = 20)
    @Size(max = 20, message = "従業員名(かな)は20文字以内で指定してください")
    private String nameKana;

    @Column(name = "email", length = 30)
    @Size(max = 30, message = "E-mailは30文字以内で指定してください")
    @Email(message = "E-mailの形式が正しくありません")
    private String email;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameKana() {
        return nameKana;
    }

    public void setNameKana(String nameKana) {
        this.nameKana = nameKana;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
