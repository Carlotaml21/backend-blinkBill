package blinkbill.com.repository;

import blinkbill.com.BillingData;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class BillingDataRepository {

    public List<BillingData> findAll() {
        return Collections.emptyList();
    }

    public List<BillingData> findAll(String filter) {
        return Collections.emptyList();
    }
}
