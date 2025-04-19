package blinkbill.com.controllers;

import blinkbill.com.BillingData;
import blinkbill.com.service.BillingDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BillingDataControllerTest {

    private final BillingDataService billingDataService = mock(BillingDataService.class);

    private BillingDataController billingDataController;

    @BeforeEach
    void setUp() {
        billingDataController = new BillingDataController(billingDataService);
    }

    @Test
    void getBillingData() {
        final var filter = "filter";

        when(billingDataService.getAllBillingData(filter)).thenReturn(List.of());

        final var result = billingDataController.getBillingData(filter);

        assertEquals(List.of(), result.getBody());
    }
    @Test
    void postBillingData(){
        BillingData input = new BillingData("Test 1" ,"1234567A", "Calle 1", "Oviedo", "Asturias", 33011);
        BillingData saved = new BillingData("Test 1" ,"1234567A", "Calle 1", "Oviedo", "Asturias", 33011);
        saved.setId(100L);

        when(billingDataService.save(input)).thenReturn(saved);

        var result = billingDataController.postBillingData(input);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(saved, result.getBody());
        verify(billingDataService).save(input);
    }

    @Test
    void updateBillingData() {
        Long id = 100L;

        BillingData input = new BillingData("Empresa Actualizada", "B99999999", "Calle Nueva", "Gijón", "Asturias", 33201);
        BillingData updated = new BillingData("Empresa Actualizada", "B99999999", "Calle Nueva", "Gijón", "Asturias", 33201);
        updated.setId(id);

        when(billingDataService.update(id, input)).thenReturn(updated);

        var result = billingDataController.updateBillingData(id, input);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(updated, result.getBody());
        verify(billingDataService).update(id, input);
    }

}