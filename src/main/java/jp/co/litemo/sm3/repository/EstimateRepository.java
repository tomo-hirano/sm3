package jp.co.litemo.sm3.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.litemo.sm3.model.Estimate;

public interface EstimateRepository extends JpaRepository<Estimate, Integer> {

    @Query("SELECT COUNT(e) FROM Estimate e WHERE e.issueDate BETWEEN :startDate AND :endDate")
    int countEstimatesOnDay(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT e FROM Estimate e WHERE " +
            "(:estimateNo IS NULL OR e.estimateNo LIKE :estimateNo%) AND " +
            "(:title IS NULL OR e.title LIKE %:title%) AND " +
            "e.issueDate BETWEEN :issueDateStart AND :issueDateEnd AND " +
            "e.effectiveDate BETWEEN :effectiveDateStart AND :effectiveDateEnd AND " +
            "(:picEmployeeId IS NULL OR e.picEmployee.id = :picEmployeeId) AND " +
            "(:customerId IS NULL OR e.customer.id = :customerId)")
    List<Estimate> findEstimatesByCondition(
            @Param("estimateNo") String estimateNo,
            @Param("title") String title,
            @Param("issueDateStart") Date issueDateStart,
            @Param("issueDateEnd") Date issueDateEnd,
            @Param("effectiveDateStart") Date effectiveDateStart,
            @Param("effectiveDateEnd") Date effectiveDateEnd,
            @Param("picEmployeeId") Integer picEmployeeId,
            @Param("customerId") Integer customerId
    );
}
