package blinkbill.com.controllers;

import blinkbill.com.BillingData;
import blinkbill.com.service.BillingDataService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/billing")
public class BillingDataController {

    private final BillingDataService billingDataService;

    public BillingDataController(BillingDataService billingDataService) {
        this.billingDataService = billingDataService;
    }

    @GetMapping()
    public ResponseEntity<List<BillingData>> getBillingData(@Param("filter") String filter) {
        List<BillingData> billingDataList = billingDataService.getAllBillingData(filter);
        return ResponseEntity.ok(billingDataList);
    }

}
