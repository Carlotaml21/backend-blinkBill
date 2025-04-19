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
    @Test
    void getAllBillingData_withFilter_callsFilteredMethod() {
        String filter = "filter";
        List<BillingData> expected = List.of();
        when(billingDataRepository.findAll(filter)).thenReturn(expected);

        List<BillingData> result = billingDataService.getAllBillingData(filter);

        assertEquals(expected, result);
        verify(billingDataRepository).findAll(filter);
        verify(billingDataRepository, never()).findAll();
    }
    @Test
    void saveBillingData_savesAndReturns() {
        BillingData input = new BillingData("Empresa test", "Y12345678", "calle", "oviedo", "Asturias", 33011);
        BillingData saved = new BillingData("Empresa test", "Y12345678", "calle", "oviedo", "Asturias", 33011);
        saved.setId(101L);

        when(billingDataRepository.save(input)).thenReturn(saved);

        BillingData result = billingDataService.save(input);

        assertEquals(saved, result);
        verify(billingDataRepository).save(input);
    }

}