package blinkbill.com.service;

import blinkbill.com.BillingData;
import blinkbill.com.repository.BillingDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BillingDataServiceTest {

    private final BillingDataRepository billingDataRepository = mock(BillingDataRepository.class);

    private BillingDataService billingDataService;

    @BeforeEach
    void setUp() {
        billingDataService = new BillingDataService(billingDataRepository);
    }

    @Test
    void getAllBillingData_withoutFilter_returnsAll() {
        List<BillingData> expected = List.of();
        when(billingDataRepository.findAll()).thenReturn(expected);

        List<BillingData> result = billingDataService.getAllBillingData(null);

        assertEquals(expected, result);
        verify(billingDataRepository).findAll();
        verify(billingDataRepository, never()).findAll(anyString());
    }
    @Test
    void getAllBillingData_withEmptyFilter_returnsAll() {
        List<BillingData> expected = List.of();
        when(billingDataRepository.findAll()).thenReturn(expected);

        List<BillingData> result = billingDataService.getAllBillingData("");

        assertEquals(expected, result);
        verify(billingDataRepository).findAll();
        verify(billingDataRepository, never()).findAll(anyString());
    }



}