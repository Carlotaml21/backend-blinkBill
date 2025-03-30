package blinkbill.com.service;

import blinkbill.com.BillingData;
import blinkbill.com.repository.BillingDataRepository;
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

}
