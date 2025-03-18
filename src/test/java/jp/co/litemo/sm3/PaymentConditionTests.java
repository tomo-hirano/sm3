package jp.co.litemo.sm3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import jp.co.litemo.sm3.controller.PaymentConditionController;
import jp.co.litemo.sm3.model.PaymentCondition;
import jp.co.litemo.sm3.service.PaymentConditionService;

public class PaymentConditionTests {

    @Mock
    private PaymentConditionService paymentConditionService;

    @InjectMocks
    private PaymentConditionController paymentConditionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePaymentCondition() {
        PaymentCondition paymentCondition = new PaymentCondition();
        paymentCondition.setName("Test Condition");
        paymentCondition.setDueDate(15);
        paymentCondition.setMonthOffset(1);
        paymentCondition.setCutOff(10);

        when(paymentConditionService.savePaymentCondition(any(PaymentCondition.class)))
                .thenReturn(paymentCondition);

        ResponseEntity<PaymentCondition> response = paymentConditionController.createPaymentCondition(paymentCondition);

        assertNotNull(response.getBody());
        assertEquals("Test Condition", response.getBody().getName());
    }

    @Test
    public void testGetPaymentConditionById() {
        PaymentCondition paymentCondition = new PaymentCondition();
        paymentCondition.setId(1);
        paymentCondition.setName("Test Condition");

        when(paymentConditionService.getPaymentConditionById(1))
                .thenReturn(Optional.of(paymentCondition));

        ResponseEntity<PaymentCondition> response = paymentConditionController.getPaymentConditionById(1);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals("Test Condition", response.getBody().getName());
    }

    @Test
    public void testDeletePaymentCondition() {
        doNothing().when(paymentConditionService).deletePaymentCondition(1);

        ResponseEntity<Void> response = paymentConditionController.deletePaymentCondition(1);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(paymentConditionService, times(1)).deletePaymentCondition(1);
    }
}
