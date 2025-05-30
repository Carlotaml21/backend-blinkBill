package blinkbill.com.controllers;

import blinkbill.com.BillingData;
import blinkbill.com.service.BillingDataService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<BillingData> postBillingData(@RequestBody BillingData billingData) {
        BillingData savedData = billingDataService.save(billingData);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillingData> updateBillingData(@PathVariable Long id, @RequestBody BillingData billingData) {
        BillingData updated = billingDataService.update(id, billingData);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillingData(@PathVariable Long id) {
        billingDataService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
