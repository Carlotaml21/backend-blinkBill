package blinkbill.com.service;

import blinkbill.com.BillingData;
import blinkbill.com.repository.BillingDataRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingDataService {

    private final BillingDataRepository billingDataRepository;

    public BillingDataService(BillingDataRepository billingDataRepository) {
        this.billingDataRepository = billingDataRepository;
    }

    public List<BillingData> getAllBillingData(String filter) {
        if (filter == null || filter.isEmpty()) {
            return billingDataRepository.findAll();
        }
        return billingDataRepository.findAll(filter);
    }

    public BillingData save(BillingData billingData) {
        return billingDataRepository.save(billingData);
    }

    public BillingData update(Long id, BillingData billingData) {
        BillingData existing = billingDataRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company with ID " + id + " not found"));

        existing.setName(billingData.getName());
        existing.setTaxId(billingData.getTaxId());
        existing.setAddress(billingData.getAddress());
        existing.setCity(billingData.getCity());
        existing.setProvince(billingData.getProvince());
        existing.setPostalCode(billingData.getPostalCode());

        return billingDataRepository.save(existing);
    }


}
