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


    @Test
    void testFindAllWithFilter() {
        String filter = "test";
        BillingData data = new BillingData();
        List<BillingData> expected = List.of(data);

        when(repositoryJPA.findAllByNameContainingIgnoreCaseOrTaxIdContainingIgnoreCase(filter, filter))
                .thenReturn(expected);

        List<BillingData> result = billingDataRepository.findAll(filter);

        assertEquals(expected, result);
        verify(repositoryJPA, times(1))
                .findAllByNameContainingIgnoreCaseOrTaxIdContainingIgnoreCase(filter, filter);
    }

    @Test
    void testSave() {
        BillingData input = new BillingData();
        input.setName("Empresa Ejemplo");
        input.setTaxId("B12345678");
        input.setAddress("Calle Falsa 123");
        input.setCity("Madrid");
        input.setProvince("Madrid");
        input.setPostalCode(28080);

        BillingData saved = new BillingData();
        saved.setId(1L);
        saved.setName("Empresa Ejemplo");
        saved.setTaxId("B12345678");
        saved.setAddress("Calle Falsa 123");
        saved.setCity("Madrid");
        saved.setProvince("Madrid");
        saved.setPostalCode(28080);

        when(repositoryJPA.save(input)).thenReturn(saved);

        BillingData result = billingDataRepository.save(input);

        assertEquals(saved, result);
        verify(repositoryJPA, times(1)).save(input);
    }

    @Test
    void testFindById() {
        Long id = 1L;

        BillingData expected = new BillingData();
        expected.setId(id);
        expected.setName("Empresa");
        expected.setTaxId("X12345678");
        expected.setAddress("Calle");
        expected.setCity("Ciudad");
        expected.setProvince("Provincia");
        expected.setPostalCode(12345);

        when(repositoryJPA.findById(id)).thenReturn(java.util.Optional.of(expected));

        var result = billingDataRepository.findById(id);

        assertTrue(result.isPresent());
        assertEquals(expected, result.get());
        verify(repositoryJPA, times(1)).findById(id);
    }

    @Test
    void testDelete() {
        BillingData data = new BillingData();
        data.setId(1L);

        doNothing().when(repositoryJPA).delete(data);

        billingDataRepository.delete(data);

        verify(repositoryJPA, times(1)).delete(data);
    }


}