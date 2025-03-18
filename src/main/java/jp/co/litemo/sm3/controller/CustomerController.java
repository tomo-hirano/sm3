package jp.co.litemo.sm3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.litemo.sm3.model.Customer;
import jp.co.litemo.sm3.service.CustomerService;

/**
 * 顧客情報管理のコントローラークラス
 * 変換元ファイル: /Domain/DomainObject/Customer.vb
 * 変換概要: VBの顧客管理ロジックをJava Springのコントローラーに変換
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 全顧客情報を取得する
     * @return 顧客情報のリスト
     */
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * 顧客IDで顧客情報を取得する
     * @param id 顧客ID
     * @return 顧客情報
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * 新しい顧客情報を登録する
     * @param customer 顧客情報
     * @return 登録された顧客情報
     */
    @PostMapping
    public Customer createCustomer(@Validated @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    /**
     * 顧客情報を更新する
     * @param id 顧客ID
     * @param customer 更新する顧客情報
     * @return 更新された顧客情報
     */
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @Validated @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * 顧客情報を削除する
     * @param id 顧客ID
     * @return 削除結果
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        if (customerService.deleteCustomer(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}