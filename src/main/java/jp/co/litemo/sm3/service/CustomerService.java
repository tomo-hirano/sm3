package jp.co.litemo.sm3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.litemo.sm3.model.Customer;
import jp.co.litemo.sm3.repository.CustomerRepository;

/**
 * 顧客情報管理のサービスクラス
 * 変換元ファイル: /Infrastructure/RepositoryImpl/CustomerRepositoryImpl.vb
 * 変換概要: VBの顧客管理ロジックをJava Springのサービスクラスに変換
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * 全顧客情報を取得する
     * @return 顧客情報のリスト
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * 顧客IDで顧客情報を取得する
     * @param id 顧客ID
     * @return 顧客情報
     */
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    /**
     * 新しい顧客情報を登録する
     * @param customer 顧客情報
     * @return 登録された顧客情報
     */
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * 顧客情報を更新する
     * @param id 顧客ID
     * @param customer 更新する顧客情報
     * @return 更新された顧客情報
     */
    public Optional<Customer> updateCustomer(Integer id, Customer customer) {
        return customerRepository.findById(id).map(existingCustomer -> {
            existingCustomer.setName(customer.getName());
            existingCustomer.setKanaName(customer.getKanaName());
            existingCustomer.setPic(customer.getPic());
            existingCustomer.setPaymentCondition(customer.getPaymentCondition());
            existingCustomer.setPostalCode(customer.getPostalCode());
            existingCustomer.setAddress1(customer.getAddress1());
            existingCustomer.setAddress2(customer.getAddress2());
            return customerRepository.save(existingCustomer);
        });
    }

    /**
     * 顧客情報を削除する
     * @param id 顧客ID
     * @return 削除結果
     */
    public boolean deleteCustomer(Integer id) {
        return customerRepository.findById(id).map(customer -> {
            customerRepository.delete(customer);
            return true;
        }).orElse(false);
    }
}