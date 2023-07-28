package loja.prova.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import loja.prova.model.PcPronto;
import loja.prova.repository.PcProntoRepository;
import loja.prova.service.PcProntoService;

public class PcProntoServiceImplement implements PcProntoService{

	@Autowired
	PcProntoRepository pcProntoRepository;
	
	public List<PcPronto> findAll() {
		// TODO Auto-generated method stub
		return pcProntoRepository.findAll();
	}

	
	public PcPronto findById(Long Id) {
		// TODO Auto-generated method stub
		return pcProntoRepository.findById(Id).get();
	}

	
	public PcPronto save(PcPronto pc_pronto) {
		// TODO Auto-generated method stub
		return pcProntoRepository.save(pc_pronto);
	}

}
