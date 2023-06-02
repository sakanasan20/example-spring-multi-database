package tw.niq.example.repository.scm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.niq.example.entity.scm.DeliveryInspectionReport;

@Repository
public interface DeliveryInspectionReportRepository extends JpaRepository<DeliveryInspectionReport, Long> {

}
