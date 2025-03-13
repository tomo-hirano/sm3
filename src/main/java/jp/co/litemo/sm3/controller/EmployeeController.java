package jp.co.litemo.sm3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.litemo.sm3.model.Employee;
import jp.co.litemo.sm3.service.EmployeeService;

/**
 * 元のファイル名: /Application/Form/EmployeeEntry.vb, /Application/Form/EmployeeList.vb
 * このクラスは従業員情報の管理を行うRESTコントローラです。
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 新しい従業員を登録します。
     * @param employee 登録する従業員情報
     * @return 登録された従業員情報
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    /**
     * すべての従業員情報を取得します。
     * @return 従業員情報のリスト
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    /**
     * 従業員番号で従業員情報を取得します。
     * @param employeeNo 従業員番号
     * @return 従業員情報
     */
    @GetMapping("/{employeeNo}")
    public ResponseEntity<Employee> getEmployeeByNo(@PathVariable("employeeNo") String employeeNo) {
        Employee employee = employeeService.getEmployeeByNo(employeeNo);
        return ResponseEntity.ok(employee);
    }
}
