package jp.co.litemo.sm3.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

	@Autowired
    Validator validator;

	@Test
    public void testEmployeeCreation() {
        Employee employee = new Employee();
        employee.setEmployeeNo("12345");
        employee.setName("John Doe");
        employee.setNameKana("ジョン ドウ");
        employee.setEmail("john.doe@example.com");

        assertEquals("12345", employee.getEmployeeNo());
        assertEquals("John Doe", employee.getName());
        assertEquals("ジョン ドウ", employee.getNameKana());
        assertEquals("john.doe@example.com", employee.getEmail());
    }

    @Test
    public void testInvalidEmail() {
        Employee employee = new Employee();
        employee.setEmail("invalid-email");
        
        assertNotEquals("invalid-email", employee.getEmail());
    }
}
