package blinkbill.com.repository;

import blinkbill.com.BillingData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BillingDataRepositoryTest {

    private final BillingDataRepositoryJPA repositoryJPA = Mockito.mock(BillingDataRepositoryJPA.class);

    private BillingDataRepository billingDataRepository;

    @BeforeEach
    void setUp() {
        billingDataRepository = new BillingDataRepository(repositoryJPA);
    }

    @Test
    void testFindAll() {
        BillingData data1 = new BillingData();
        BillingData data2 = new BillingData();
        List<BillingData> expectedList = List.of(data1, data2);

        when(repositoryJPA.findAll()).thenReturn(expectedList);

        List<BillingData> result = billingDataRepository.findAll();

        assertEquals(expectedList, result);
        verify(repositoryJPA, times(1)).findAll();
    }

}