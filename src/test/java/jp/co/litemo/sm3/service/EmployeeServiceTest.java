package jp.co.litemo.sm3.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jp.co.litemo.sm3.model.Employee;
import jp.co.litemo.sm3.repository.EmployeeRepository;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeNo("12345");
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.saveEmployee(employee);
        assertNotNull(savedEmployee);
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void testGetEmployeeByNo() {
        Employee employee = new Employee();
        employee.setEmployeeNo("12345");
        when(employeeRepository.findByEmployeeNo("12345")).thenReturn(employee);

        Employee foundEmployee = employeeService.getEmployeeByNo("12345");
        assertEquals("12345", foundEmployee.getEmployeeNo());
    }
}
