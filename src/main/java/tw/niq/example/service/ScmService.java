package tw.niq.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.niq.example.entity.scm.ActionLog;
import tw.niq.example.entity.scm.DeliveryInspectionReport;
import tw.niq.example.repository.scm.ActionLogRepository;
import tw.niq.example.repository.scm.DeliveryInspectionReportRepository;

@Service
public class ScmService {

	@Autowired
	private DeliveryInspectionReportRepository deliveryInspectionReportRepository;
	
	@Autowired
	private ActionLogRepository actionLogRepository;
	
	public List<DeliveryInspectionReport> findAllDeliveryInspectionReport() {
		return deliveryInspectionReportRepository.findAll();
	}
	
	public List<ActionLog> findAllActionLog() {
		return actionLogRepository.findAll();
	}
	
}
