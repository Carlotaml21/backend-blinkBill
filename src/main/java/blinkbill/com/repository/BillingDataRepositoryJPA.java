package blinkbill.com.repository;

import blinkbill.com.BillingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingDataRepositoryJPA extends JpaRepository<BillingData, Long> {

}
