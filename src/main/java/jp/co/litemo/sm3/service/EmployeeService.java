package jp.co.litemo.sm3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.litemo.sm3.model.Employee;
import jp.co.litemo.sm3.repository.EmployeeRepository;

/**
 * 元のファイル名: /Application/Form/EmployeeEntry.vb, /Application/Form/EmployeeList.vb
 * このクラスは従業員情報のビジネスロジックを提供します。
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 従業員情報を保存します。
     * @param employee 保存する従業員情報
     * @return 保存された従業員情報
     */
    @Transactional
    public Employee saveEmployee(Employee employee) {
        // バリデーションロジックをここに追加することができます
        return employeeRepository.save(employee);
    }

    /**
     * すべての従業員情報を取得します。
     * @return 従業員情報のリスト
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * 従業員番号で従業員情報を取得します。
     * @param employeeNo 従業員番号
     * @return 従業員情報
     */
    public Employee getEmployeeByNo(String employeeNo) {
        return employeeRepository.findByEmployeeNo(employeeNo);
    }
}
