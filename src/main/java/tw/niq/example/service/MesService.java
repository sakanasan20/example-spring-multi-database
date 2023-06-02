package tw.niq.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.niq.example.entity.mes.TempTcItb;
import tw.niq.example.repository.mes.TempTcItbRepository;

@Service
public class MesService {

	@Autowired
	private TempTcItbRepository tempTcItbRepository;
	
	public List<TempTcItb> findAllTempTcItb() {
		return tempTcItbRepository.findAll();
	}
	
}
