package jp.co.litemo.sm3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class EmployeeTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

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
        
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        assertFalse(violations.isEmpty(), "Expected validation errors for invalid email");
    }
}
