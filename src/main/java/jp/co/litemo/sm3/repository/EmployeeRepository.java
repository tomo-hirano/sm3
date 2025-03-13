package jp.co.litemo.sm3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.litemo.sm3.model.Employee;

/**
 * 元のファイル名: /Infrastructure/RepositoryImpl/EmployeeRepositoryImpl.vb
 * このインターフェースは従業員情報のデータアクセスを提供します。
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * 従業員番号で従業員情報を取得します。
     * @param employeeNo 従業員番号
     * @return 従業員情報
     */
    Employee findByEmployeeNo(String employeeNo);

    /**
     * 名前で従業員情報を取得します。
     * @param name 名前
     * @return 従業員情報のリスト
     */
    List<Employee> findByNameContaining(String name);

    /**
     * 名前(かな)で従業員情報を取得します。
     * @param nameKana 名前(かな)
     * @return 従業員情報のリスト
     */
    List<Employee> findByNameKanaContaining(String nameKana);
}
