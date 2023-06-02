package tw.niq.example.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import tw.niq.example.service.ErpService;
import tw.niq.example.service.MesService;
import tw.niq.example.service.ScmService;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
	
	@Autowired
	private ScmService scmService;
	
	@Autowired
	private MesService mesService;
	
	@Autowired
	private ErpService erpService;

	@Override
	public void run(String... args) throws Exception {
		log.info("scmService.findAllDeliveryInspectionReport().size(): " + scmService.findAllDeliveryInspectionReport().size());
		log.info("scmService.findAllActionLog().size(): " + scmService.findAllActionLog().size());
		log.info("mesService.findAllTempTcItb().size(): " + mesService.findAllTempTcItb().size());
		log.info("erpService.findAllTcSckFile().size(): " + erpService.findAllTcSckFile().size());
	}

}
