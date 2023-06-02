package tw.niq.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.niq.example.entity.erp.TcSckFile;
import tw.niq.example.repository.erp.TcSckFileRepository;

@Service
public class ErpService {

	@Autowired
	private TcSckFileRepository tcSckFileRepository;
	
	public List<TcSckFile> findAllTcSckFile() {
		return tcSckFileRepository.findAll();
	}
	
}
