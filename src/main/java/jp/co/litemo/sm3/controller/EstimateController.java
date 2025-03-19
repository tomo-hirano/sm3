package jp.co.litemo.sm3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.litemo.sm3.model.Estimate;
import jp.co.litemo.sm3.service.EstimateService;

@RestController
@RequestMapping("/api/estimates")
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @GetMapping
    public ResponseEntity<List<Estimate>> getAllEstimates() {
        List<Estimate> estimates = estimateService.findAllEstimates();
        return ResponseEntity.ok(estimates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estimate> getEstimateById(@PathVariable("id") Integer id) {
        Optional<Estimate> estimate = estimateService.findEstimateById(id);
        return estimate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estimate> createEstimate(@RequestBody Estimate estimate) {
        Estimate savedEstimate = estimateService.saveEstimate(estimate);
        return ResponseEntity.ok(savedEstimate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estimate> updateEstimate(@PathVariable("id") Integer id, @RequestBody Estimate estimate) {
        estimate.setId(id);
        Estimate updatedEstimate = estimateService.saveEstimate(estimate);
        return ResponseEntity.ok(updatedEstimate);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEstimate(@PathVariable Integer id) {
//        estimateService.deleteEstimate(id);
//        return ResponseEntity.noContent().build();
//    }
}
