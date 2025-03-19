package jp.co.litemo.sm3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.litemo.sm3.model.Estimate;
import jp.co.litemo.sm3.repository.EstimateRepository;

@Service
public class EstimateService {

    @Autowired
    private EstimateRepository estimateRepository;

    @Transactional
    public Estimate saveEstimate(Estimate estimate) {
        // ビジネスロジックをここに実装
        // 例: 見積番号の生成、バリデーション、トランザクション管理など
        if (estimate.getId() == null) {
            estimate.setEstimateNo(generateEstimateNo());
        }
        return estimateRepository.save(estimate);
    }

    public Optional<Estimate> findEstimateById(Integer id) {
        return estimateRepository.findById(id);
    }

    public List<Estimate> findAllEstimates() {
        return estimateRepository.findAll();
    }

    private String generateEstimateNo() {
        // 見積番号の生成ロジック
        // 例: 今日の日付(yyyyMMdd) + その日に作られた見積全体での連番3桁(001)
        long count = estimateRepository.count();
        return String.format("%s%03d", java.time.LocalDate.now().toString().replace("-", ""), count + 1);
    }
}
