package blinkbill.com.repository;

import blinkbill.com.BillingData;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BillingDataRepository {

    private final BillingDataRepositoryJPA repositoryJPA;

    public BillingDataRepository(BillingDataRepositoryJPA repositoryJPA) {
        this.repositoryJPA = repositoryJPA;
    }

    public List<BillingData> findAll() {
        return repositoryJPA.findAll();
    }

    public BillingData save(BillingData billingData) {
        return repositoryJPA.save(billingData);
    }

    public List<BillingData> findAll(String filter) {
        return repositoryJPA.findAllByNameContainingIgnoreCaseOrTaxIdContainingIgnoreCase(filter, filter);
    }
}
