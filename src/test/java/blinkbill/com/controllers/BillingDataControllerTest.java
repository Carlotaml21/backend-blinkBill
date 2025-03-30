package blinkbill.com.controllers;

import blinkbill.com.BillingData;
import blinkbill.com.service.BillingDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

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

        Mockito.when(billingDataService.getAllBillingData(filter)).thenReturn(List.of());

        final var result = billingDataController.getBillingData(filter);

        Assertions.assertEquals(List.of(), result.getBody());
    }
}