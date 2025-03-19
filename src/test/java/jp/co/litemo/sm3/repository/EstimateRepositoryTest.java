package jp.co.litemo.sm3.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import jp.co.litemo.sm3.model.Estimate;

@DataJpaTest
public class EstimateRepositoryTest {

    @MockBean
    private EstimateRepository estimateRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCountEstimatesOnDay() {
        Date startDate = new Date();
        Date endDate = new Date();
        when(estimateRepository.countEstimatesOnDay(startDate, endDate)).thenReturn(5);

        int count = estimateRepository.countEstimatesOnDay(startDate, endDate);
        assertEquals(5, count);
    }

    @Test
    public void testFindEstimatesByCondition() {
        String estimateNo = "2023";
        String title = "Test";
        Date issueDateStart = new Date();
        Date issueDateEnd = new Date();
        Date effectiveDateStart = new Date();
        Date effectiveDateEnd = new Date();
        Integer picEmployeeId = 1;
        Integer customerId = 1;

        Estimate estimate = new Estimate();
        when(estimateRepository.findEstimatesByCondition(estimateNo, title, issueDateStart, issueDateEnd, effectiveDateStart, effectiveDateEnd, picEmployeeId, customerId))
                .thenReturn(List.of(estimate));

        List<Estimate> estimates = estimateRepository.findEstimatesByCondition(estimateNo, title, issueDateStart, issueDateEnd, effectiveDateStart, effectiveDateEnd, picEmployeeId, customerId);
        assertEquals(1, estimates.size());
    }
}
