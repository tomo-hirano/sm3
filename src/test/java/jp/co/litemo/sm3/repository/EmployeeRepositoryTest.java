package jp.co.litemo.sm3.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jp.co.litemo.sm3.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindByEmployeeNo() {
        Employee employee = new Employee();
        employee.setEmployeeNo("12345");
        employee.setName("John Doe");
        employeeRepository.save(employee);

        Employee foundEmployee = employeeRepository.findByEmployeeNo("12345");
        assertNotNull(foundEmployee);
        assertEquals("John Doe", foundEmployee.getName());
    }
}
