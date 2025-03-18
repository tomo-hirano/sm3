package jp.co.litemo.sm3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.litemo.sm3.model.Customer;

/**
 * 顧客情報の永続化のためのリポジトリインターフェース
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * 顧客名と住所から顧客を検索
     * @param name 顧客名
     * @param address1 住所1
     * @param address2 住所2
     * @return 顧客情報
     */
    Customer findByNameAndAddress1AndAddress2(String name, String address1, String address2);

    /**
     * 顧客名、かな名、営業担当者、住所で顧客を検索
     * @param name 顧客名
     * @param kanaName かな名
     * @param picId 営業担当者ID
     * @param address 住所
     * @return 顧客情報のリスト
     */
    List<Customer> findByNameContainingAndKanaNameContainingAndPicIdAndAddress1ContainingOrAddress2Containing(
            String name, String kanaName, Integer picId, String address1, String address2);
}
